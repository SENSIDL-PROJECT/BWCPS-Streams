package $_1.security;

import $_1.Node;
import java.security.PublicKey;

public interface SecurableNode extends Node{
	
	public PublicKey getPublicKey();
	
	public void receiveEncryptedKey(SecurityMeasure securityMeasure, SecurableNode node, byte[] key);
	
}
