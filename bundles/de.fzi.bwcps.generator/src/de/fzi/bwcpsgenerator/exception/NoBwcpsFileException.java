package de.fzi.bwcpsgenerator.exception;

/**
 * Exception class for the case that the given file is not a bwcps file
 * 
 *
 */
public class NoBwcpsFileException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param message
	 *            the error message
	 */
	public NoBwcpsFileException(String message) {
		super(message);
	}

}
