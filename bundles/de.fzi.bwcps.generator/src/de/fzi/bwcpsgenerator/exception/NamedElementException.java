package de.fzi.bwcpsgenerator.exception;

public class NamedElementException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NamedElementException(Object o) {
        super("The Object" + o.toString() + "is not an instance of NamedElement.");
    }
}
