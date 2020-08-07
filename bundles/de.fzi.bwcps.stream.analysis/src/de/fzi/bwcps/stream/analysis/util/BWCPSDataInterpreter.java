package de.fzi.bwcps.stream.analysis.util;

import java.util.List;

import de.fzi.sensidl.design.sensidl.dataRepresentation.Data;

/**
 * Interface for attaching concrete data sizes to the abstract SensIDL data representations.
 * @author Fabian Scheytt
 *
 * @see BWCPSDataInterpreterImpl
 */
public interface BWCPSDataInterpreter {
	/**
	 * Returns the summed size of the given data types in BYTE.
	 * For this reference implementation the data type sizes are FICTIONAL. TODO: This should be adapted/modeled
	 * for a more precise analysis!
	 * @param data
	 * @return summed up size of data types
	 */
	public int determineSizeOfData(List<Data> data);
	
	/**
	 * Returns the size of the given data type in BYTE.
	 * For this reference implementation the data type sizes are FICTIONAL. TODO: This should be adapted/modeled
	 * for a more precise analysis!
	 * @param data
	 * @return size of data type
	 */
	public int determineSizeOfData(Data data);
}
