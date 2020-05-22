package de.fzi.bwcps.stream.analysis.util;

import java.util.List;

import de.fzi.sensidl.design.sensidl.dataRepresentation.Data;

public class BWCPSDataInterpreterImpl implements BWCPSDataInterpreter{
	
	public int determineSizeOfData(List<Data> data) {
		int bits = 0;
		for(Data d : data)
			bits+= determineSizeOfData(d);
		return bits;
	}
	
	public int determineSizeOfData(Data data) {
		switch (data.getDataType()) {
		case BOOLEAN:
			return 1;
		case DOUBLE:
			return 64;
		case FLOAT:
			return 32;
		case INT16:
			return 16;
		case INT32:
			return 32;
		case INT64:
			return 64;
		case INT8:
			return 8;
		case STRING:
			return 100;
		case UINT16:
			return 16;
		case UINT32:
			return 32;
		case UINT64:
			return 64;
		case UINT8:
			return 8;
		case UNDEFINED:
		default:
			return 0;
		
		}
	}
}
