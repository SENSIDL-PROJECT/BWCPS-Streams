package de.fzi.bwcps.generator.nodeconfiguration.security;

import de.fzi.bwcps.generator.nodeconfiguration.Node;
import java.security.PublicKey;

public interface SecurableNode extends Node{
	
	public PublicKey getPublicKey();
	
	public void receiveEncryptedKey(SecurityMeasure securityMeasure, SecurableNode node, byte[] key);
	
	public void establishConnection(SecurityMeasure securityMeasure, SecurableNode serviceRequester, PublicKey requestersPK);
}
