package $_1.security;

import $_1.security.SecurableNode;

public class NotConnectedException extends Exception{

    public NotConnectedException() {
        super("The nodes are not connected. Call establishConnection to connect them.");
    }
}
