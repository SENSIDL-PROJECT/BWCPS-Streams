package de.fzi.bwcpsgenerator.exception;

public class MetamodelException extends Exception {
	
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
	public MetamodelException(String error) {
        super(error);
    }
}
