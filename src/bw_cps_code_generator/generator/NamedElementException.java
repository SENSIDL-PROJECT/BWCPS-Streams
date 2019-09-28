package bw_cps_code_generator.generator;

public class NamedElementException extends Exception {
	
    public NamedElementException(Object o) {
        super("The Object" + o.toString() + "is not an instance of NamedElement.");
    }
}
