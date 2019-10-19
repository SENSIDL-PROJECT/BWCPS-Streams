package bw_cps_code_generator.generator.factory.kuracomponents

import bw_cps_code_generator.generator.BwCPSConstants
import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider
import bw_cps_code_generator.generator.GenerationUtil
import bw_cps_code_generator.generator.factory.IDTOGenerator
import de.fzi.bwcps.stream.bwcps_streams.entity.Node
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure

class SecurityUtilityGenerator {
	static val Logger logger = Logger.getLogger(SecurityUtilityGenerator)

	val String projectName

	
	private val String packagePrefix
	
	new(String projectName, String newPackagePrefix) {
		this.projectName = projectName
		packagePrefix = newPackagePrefix
	}

	def generate(List<NodeLink> nodelinks) {
		logger.info("Generate SecurityUtil class.")

		val filesToGenerate = new HashMap
		filesToGenerate.put(addFileExtensionTo("SecurityUtil"),
			getSecurityUtilBody())
			logger.info("File: " + addFileExtensionTo("AESEncrypt") + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		if (nodelinks.exists[n| n.securityMeasure.contains(SecurityMeasure.ENCRYPT)]){
			filesToGenerate.put(addFileExtensionTo("AESEncrypt"),
			getAESEncryptBody())
			logger.info("File: " + addFileExtensionTo("AESEncrypt") + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}
		filesToGenerate
	}
	
	def getSecurityUtilBody() {
		'''
			package «packagePrefix»«projectName.toLowerCase»;
		'''
	}

	def getAESEncryptBody()	{
		'''
		package «packagePrefix»«projectName.toLowerCase»;
		
		import java.io.IOException;
		import java.nio.charset.StandardCharsets;
		import java.security.GeneralSecurityException;
		import java.security.InvalidAlgorithmParameterException;
		import java.security.InvalidKeyException;
		import java.util.Properties;
		
		import javax.crypto.BadPaddingException;
		import javax.crypto.Cipher;
		import javax.crypto.IllegalBlockSizeException;
		import javax.crypto.ShortBufferException;
		import javax.crypto.spec.IvParameterSpec;
		import javax.crypto.spec.SecretKeySpec;
		
		import org.apache.commons.crypto.cipher.CryptoCipher;
		import org.apache.commons.crypto.cipher.CryptoCipherFactory;
		import org.apache.commons.crypto.cipher.CryptoCipherFactory.CipherProvider;
		import org.apache.commons.crypto.random.CryptoRandom;
		import org.apache.commons.crypto.random.CryptoRandomFactory;
		import org.apache.commons.crypto.utils.Utils;
		import java.util.Base64;
		
		public class AESEncrypt{
			
			static final int MIN_OUT_BUFFER_SIZE = 32;
			final String transform = "AES/CBC/PKCS5Padding";
		    CryptoCipher encipher;
		    SecretKeySpec key;
		    IvParameterSpec iv;
		    byte[] IVBytes = new byte[16];
		    CryptoRandom random;
		    
			public AESEncrypt(String cipherKey){
				
			    
			    try {
				    key = new SecretKeySpec(getUTF8Bytes(cipherKey),"AES");
				    Properties properties = new Properties();
			    	properties.setProperty(CryptoCipherFactory.CLASSES_KEY,
			    			CipherProvider.OPENSSL.getClassName());
					encipher = Utils.getCipherInstance(transform, properties);
					
					
					Properties randProperties = new Properties();
					randProperties.put(CryptoRandomFactory.CLASSES_KEY,
			            CryptoRandomFactory.RandomProvider.OPENSSL.getClassName());
		
			        // Gets the 'CryptoRandom' instance.
			        random = CryptoRandomFactory.getCryptoRandom(randProperties);
		
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (GeneralSecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			private String encrypt(String orgData) {
				byte[] input = getUTF8Bytes(orgData);
				int len = input.length*2;
				if(len <MIN_OUT_BUFFER_SIZE){
					len = MIN_OUT_BUFFER_SIZE;
				}
			    byte[] output = new byte[len];
			    int total  = 0;
				try{
					random.nextBytes(IVBytes);
					iv = new IvParameterSpec(IVBytes);
					
				    //Initializes the cipher with ENCRYPT_MODE, key and iv.
				    encipher.init(Cipher.ENCRYPT_MODE, key, iv);
				    //Continues a multiple-part encryption/decryption operation for byte array.
				    int updateBytes = encipher.update(input, 0, input.length, output, 0);
				    //System.out.println(updateBytes);
				    //We must call doFinal at the end of encryption/decryption.
				    int finalBytes = encipher.doFinal(input, 0, 0, output, updateBytes);
				    //System.out.println(finalBytes);
				    total = updateBytes+finalBytes;
				    
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				} catch (InvalidAlgorithmParameterException e) {
					e.printStackTrace();
				} catch (ShortBufferException e) {
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					e.printStackTrace();
				} catch (BadPaddingException e) {
					e.printStackTrace();
				}finally{
					try {
						encipher.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				return encodeB64(IVBytes) + ":" + encodeB64(output,total);
			}
		
			public String op1(String data) {
				return encrypt(data);
			}
		
			public void close() {
				 try {
					encipher.close();
				} catch (IOException e) {
				}
			}
			
			
			/**
			 * Converts String to UTF8 bytes
			 *
			 * @param input the input string
			 * @return UTF8 bytes
			 */
			static private byte[] getUTF8Bytes(String input) {
			    return input.getBytes(StandardCharsets.UTF_8);
			}
			public static String encodeB64(byte[] data){
				return Base64.getEncoder().encodeToString(data);
			}
			public static String encodeB64(byte[] data,int total){
				byte[] sub = new byte[total];
				System.arraycopy(data, 0, sub, 0, total);
				return Base64.getEncoder().encodeToString(sub);
			}
		}
		'''
	}
	
	def addFileExtensionTo(String className) {
		return className + BwCPSConstants.JAVA_EXTENSION
	}
	

}
