package de.fzi.bwcpsgenerator.exception;

public class ExistingProjectException extends Exception {
	
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
	public ExistingProjectException(String projectName) {
        super("Project " + projectName + " already exists.");
    }
}
