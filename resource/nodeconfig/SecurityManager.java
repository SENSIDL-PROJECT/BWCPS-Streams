package $_1.security;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.favre.lib.crypto.HKDF;

import $_1.security.SecurableNode;
import $_1.security.SecurityMeasure;

/**
 * Node: Sensor
 *
 * @generated
 */

public class SecurityManager {
	
	private static final Logger s_logger = LoggerFactory.getLogger(SecurityManager.class);
	
	private static final String HMAC_ALGO = "HmacSHA256";
	private final static String AES_CIPHER_ALGO = "AES/CBC/PKCS5Padding";
	private final static String RSA_CIPHER_ALGO = "RSA/ECB/PKCS1Padding";
	private final static String AES_KEY_ALGO = "AES";
	private final static String RSA_KEY_ALGO = "RSA";
	
	private final static int AES_KEY_LENGTH = 128;
	private final static int IV_LENGTH = AES_KEY_LENGTH / 8;
	private static final int RSA_KEY_LENGTH = 2048;
	private static final int HMAC_ENCKEY_LENGTH = 16;
	private static final int HMAC_AUTHKEY_LENGTH = 32;
	
	private PrivateKey privateKey;

	private PublicKey publicKey;

	private SecureRandom random;
	private Cipher cipherAES;
	private IvParameterSpec iv;
	private byte[] IVBytes = new byte[IV_LENGTH];

	private HashMap<SecurableNode, SimpleEntry<SecurityMeasure, SecretKey>> connections = new HashMap<SecurableNode, SimpleEntry<SecurityMeasure, SecretKey>>();
	
	private byte[] encryptKey(PublicKey publicKey, SecretKey skey) {
		try {
			// init cipher
			Cipher cipher;
			cipher = Cipher.getInstance(RSA_CIPHER_ALGO);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);

			// encrypt
			return cipher.doFinal(skey.getEncoded());

		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	private void exchangeKey(SecurityMeasure securityMeasure,SecurableNode serviceRequester, SecurableNode serviceProvider) {
		// create and save AESkey in TextFile Node.id + AESKey
		KeyGenerator kgen = null;
		try {
			kgen = KeyGenerator.getInstance(AES_KEY_ALGO);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		kgen.init(AES_KEY_LENGTH);
		SecretKey skey = kgen.generateKey();

		// send encrypted key to source node

		serviceRequester.receiveEncryptedKey(securityMeasure, serviceProvider, encryptKey(serviceRequester.getPublicKey(), skey));

		connections.put(serviceRequester, new SimpleEntry<SecurityMeasure, SecretKey>(securityMeasure,skey));
	}
	
	private byte[] calculateMac(byte[] data, byte[] skey) {
		byte[] mac = null;
		try {
			// generate
			SecretKey macKey = new SecretKeySpec(skey, HMAC_ALGO);
			// calculate MAC
			Mac hmac = Mac.getInstance(HMAC_ALGO);
			hmac.init(macKey);
			hmac.update(IVBytes);
			hmac.update(data);
			mac = hmac.doFinal();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}

		return mac;
	}
	
	private boolean verifyMac(byte[] data, byte[] key, byte[] mac) {
		byte[] refMac = calculateMac(data, key);

		// compare mac to refMac with constant time comparing function
		if (!MessageDigest.isEqual(refMac, mac)) {
			s_logger.error("could not authenticate");
			return false;
		}

		return true;
	}
	
	private SecretKey getKey(SecurableNode connectedNode) {
		return connections.get(connectedNode).getValue();
	}
	
	private static String encodeB64(byte[] data) {
		return Base64.getEncoder().encodeToString(data);
	}

	private static byte[] decodeB64(String cipher) {
		return Base64.getDecoder().decode(cipher);
	}
	
	public SecurityManager() {
		try {
			// generate key pair
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSA_KEY_ALGO);
			keyGen.initialize(RSA_KEY_LENGTH);
			KeyPair keyPair = keyGen.generateKeyPair();

			privateKey = keyPair.getPrivate();
			publicKey = keyPair.getPublic();

			cipherAES = Cipher.getInstance(AES_CIPHER_ALGO);

			// initialize properties for SecureRandom
			random = new SecureRandom();

		} catch (NoSuchAlgorithmException e) {
			s_logger.info("KeyPair couldn't be generated\n");
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			s_logger.info("Cipher couldn't be initialised\n");
			e.printStackTrace();
		}
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public HashMap<SecurableNode, SimpleEntry<SecurityMeasure, SecretKey>> getConnections() {
		return connections;
	}
	
	public SecretKey decryptKey(byte[] key) {
		try {
			// init cipher
			Cipher cipher;
			cipher = Cipher.getInstance(RSA_CIPHER_ALGO);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);

			// decrypt 
			byte[] input = cipher.doFinal(key);

			return new SecretKeySpec(input, AES_KEY_ALGO);

		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String encrypt(Object data, SecurableNode connectedNode) {
		SecretKey skey = getKey(connectedNode); 
		// convert object to byte array
		byte[] serializedData = SerializationUtils.serialize((Serializable) data);
		random.nextBytes(IVBytes);
		iv = new IvParameterSpec(IVBytes);
		try {
			cipherAES.init(Cipher.ENCRYPT_MODE, skey, iv);
			byte[] cipherText = cipherAES.doFinal(serializedData);
			ByteBuffer byteBuffer = ByteBuffer.allocate(1 + IVBytes.length + cipherText.length);
			byteBuffer.put((byte) IVBytes.length);
			byteBuffer.put(IVBytes);
			byteBuffer.put(cipherText);
			byte[] cipherMessage = byteBuffer.array();
			
			return encodeB64(cipherMessage);
			
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Object decrypt(String data, SecurableNode connectedNode) {
		SecretKey skey = getKey(connectedNode); 
		// retrieve cipher and iv
		byte[] encrypted = decodeB64(data);

		ByteBuffer byteBuffer = ByteBuffer.wrap(encrypted);

		int ivLength = (byteBuffer.get());

		if (ivLength != IV_LENGTH) { // check input parameter
			throw new IllegalArgumentException("invalid iv length");
		}

		byteBuffer.get(IVBytes);
		iv = new IvParameterSpec(IVBytes);

		byte[] cipherText = new byte[byteBuffer.remaining()];
		byteBuffer.get(cipherText);

		try {
			cipherAES.init(Cipher.DECRYPT_MODE, skey, iv);
			byte[] decrypted = cipherAES.doFinal(cipherText);

			return SerializationUtils.deserialize(decrypted);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String sign(Object data, SecurableNode connectedNode) {
		SecretKey skey = getKey(connectedNode); 
		// convert object to byte array
		byte[] serializedData = SerializationUtils.serialize((Serializable) data);

		random.nextBytes(IVBytes);

		byte[] mac = calculateMac(serializedData, skey.getEncoded());

		// serialize the final message
		ByteBuffer byteBuffer = ByteBuffer.allocate(1 + IVBytes.length + 1 + mac.length + serializedData.length);
		byteBuffer.put((byte) IVBytes.length);
		byteBuffer.put(IVBytes);
		byteBuffer.put((byte) mac.length);
		byteBuffer.put(mac);
		byteBuffer.put(serializedData);
		byte[] signed = byteBuffer.array();
		return encodeB64(signed);
	}

	private Object verify(String data, SecurableNode connectedNode) {
		SecretKey skey = getKey(connectedNode); 
		// retrieve cipher and iv
		byte[] signed = decodeB64(data);

		// deconstract signed data
		ByteBuffer byteBuffer = ByteBuffer.wrap(signed);

		int ivLength = (byteBuffer.get());

		if (ivLength != IV_LENGTH) { // check input parameter
			s_logger.error("invalid iv length");
			return null;
		}

		byteBuffer.get(IVBytes);
		iv = new IvParameterSpec(IVBytes);

		int macLength = (byteBuffer.get());
		if (macLength != HMAC_AUTHKEY_LENGTH) { // check input parameter
			s_logger.error("invalid mac length");
			return null;
		}
		byte[] mac = new byte[macLength];
		byteBuffer.get(mac);

		byte[] serializedData = new byte[byteBuffer.remaining()];
		byteBuffer.get(serializedData);

		if (!verifyMac(serializedData, skey.getEncoded(), mac)) {
			return null;
		}

		return SerializationUtils.deserialize(serializedData);
	}

	private String encryptThenSign(Object data, SecurableNode connectedNode) {
		SecretKey skey = getKey(connectedNode); 
		// convert object to byte array
		byte[] serializedData = SerializationUtils.serialize((Serializable) data);

		random.nextBytes(IVBytes);

		byte[] encKey = HKDF.fromHmacSha256().expand(skey, "encKey".getBytes(StandardCharsets.UTF_8), HMAC_ENCKEY_LENGTH);
		byte[] authKey = HKDF.fromHmacSha256().expand(skey, "authKey".getBytes(StandardCharsets.UTF_8), HMAC_AUTHKEY_LENGTH); // HMAC-SHA256
																												// key
																												// is 32
																												// byte

		iv = new IvParameterSpec(IVBytes);
		try {
			cipherAES.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encKey, AES_KEY_ALGO), iv);
			byte[] encrypted = cipherAES.doFinal(serializedData);

			byte[] mac = calculateMac(encrypted, authKey);

			ByteBuffer byteBuffer = ByteBuffer.allocate(1 + IVBytes.length + 1 + mac.length + encrypted.length);
			byteBuffer.put((byte) IVBytes.length);
			byteBuffer.put(IVBytes);
			byteBuffer.put((byte) mac.length);
			byteBuffer.put(mac);
			byteBuffer.put(encrypted);
			byte[] signed = byteBuffer.array();

			Arrays.fill(authKey, (byte) 0);
			Arrays.fill(encKey, (byte) 0);

			return encodeB64(signed);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Object verifyThenDecrypt(String data, SecurableNode connectedNode) {
		SecretKey skey = getKey(connectedNode); 
		// decode message
		byte[] encrypted = decodeB64(data);

		ByteBuffer byteBuffer = ByteBuffer.wrap(encrypted);

		int ivLength = (byteBuffer.get());
		if (ivLength != IV_LENGTH) { // check input parameter
			s_logger.error("invalid iv length");
			return null;
		}
		byteBuffer.get(IVBytes);
		iv = new IvParameterSpec(IVBytes);

		int macLength = (byteBuffer.get());
		if (macLength != HMAC_AUTHKEY_LENGTH) { // check input parameter
			s_logger.error("invalid mac length");
			return null;
		}
		byte[] mac = new byte[macLength];
		byteBuffer.get(mac);

		byte[] cipherText = new byte[byteBuffer.remaining()];
		byteBuffer.get(cipherText);

		byte[] encKey = HKDF.fromHmacSha256().expand(skey, "encKey".getBytes(StandardCharsets.UTF_8), HMAC_ENCKEY_LENGTH);
		byte[] authKey = HKDF.fromHmacSha256().expand(skey, "authKey".getBytes(StandardCharsets.UTF_8), HMAC_AUTHKEY_LENGTH);

		if (!verifyMac(cipherText, authKey, mac)) {
			return null;
		}

		try {
			cipherAES.init(Cipher.DECRYPT_MODE, new SecretKeySpec(encKey, AES_KEY_ALGO), iv);
			byte[] decrypted = cipherAES.doFinal(cipherText);
			return SerializationUtils.deserialize(decrypted);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String secureData(Object data, SecurableNode connectedNode) throws NotConnectedException {
		SecurityMeasure securityMeasure = connections.get(connectedNode).getKey();
		if(securityMeasure == null) {
			throw new NotConnectedException();
		}
		switch(securityMeasure) {
		case ENCRYPT: return encrypt(data, connectedNode); 
		case AUTHENTICATE: return sign(data, connectedNode);
		case ENCRYPT_THEN_AUTHENTICATE: return encryptThenSign(data, connectedNode);
		default : return null;
		}
	}
	
	public Object processData(String data,SecurableNode connectedNode) throws NotConnectedException {
		SecurityMeasure securityMeasure = connections.get(connectedNode).getKey();
		if(securityMeasure == null) {
			throw new NotConnectedException();
		}
		switch(securityMeasure) {
		case ENCRYPT: return decrypt(data, connectedNode); 
		case AUTHENTICATE: return verify(data, connectedNode);
		case ENCRYPT_THEN_AUTHENTICATE: return verifyThenDecrypt(data, connectedNode);
		default : return null;
		}
	}
	
	public void addConnection(SecurityMeasure securityMeasure, SecurableNode serviceRequester, SecurableNode serviceProvider) {
		if(getKey(serviceRequester) == null) {
			exchangeKey(securityMeasure, serviceRequester, serviceProvider);
		}
	}
	
	public void decryptAndStoreKey(SecurityMeasure securityMeasure, SecurableNode node, byte[] key) {
		connections.put(node, new SimpleEntry<SecurityMeasure, SecretKey>(securityMeasure, decryptKey(key)));
	}
}
