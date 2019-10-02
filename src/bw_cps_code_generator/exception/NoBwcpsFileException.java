package bw_cps_code_generator.exception;

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
	 * Empty constructor
	 */
	public NoBwcpsFileException() {
	}

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
