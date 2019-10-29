package $_1.security;

public class NotConnectedException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotConnectedException() {
        super("The nodes are not connected. Call establishConnection to connect them.");
    }
}
