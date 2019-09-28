package bw_cps_code_generator.generator.factory.java

import dataRepresentation.NonMeasurementData
import dataRepresentation.MeasurementData
import dataRepresentation.ListData
import dataRepresentation.Data
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import dataRepresentation.DataType
import bw_cps_code_generator.generator.GenerationUtil
import dataRepresentation.LinearDataConversionWithInterval

class JavaDataRepresentaionGenerator {
	private static val LONG_FORMATTED = "l"
	private static val FLOAT_FORMATTED = "f";
	private static val DOUBLE_FORMATTED = ".0";
	
		/**
	 * Generates the data fields for this data set including used data sets.
	 */
	def generateDataFields(NamedElement e) {
		'''
		«FOR data : e.eContents.filter(NonMeasurementData)»
			
			«generateDataFields(data)»
		«ENDFOR» 
		«FOR data : e.eContents.filter(MeasurementData)»
			«generateDataFields(data)»
		«ENDFOR» 
		«FOR data : e.eContents.filter(ListData)»
			«generateDataFields(data)»
		«ENDFOR» 

		'''
	}

	def generateDataFields(ListData data){
		'''
		
		«IF data.description != null»
		/* 
		 * «data.description»
		 */ 
		«ENDIF» 
		private List<«data.getListType»> «GenerationUtil.getEntityLowerName(data)» = new ArrayList<«data.getListType»>();
			 '''
	}
	
	/**
	 * Generates the fields for the measurement data
	 */
	def generateDataFields(MeasurementData d) {
		'''
			/*
			 «IF d.description != null»
			 * «d.description»
			 * 
			 «ENDIF» 
«««			 * Unit: «d.unit»
			 */
			private «d.toTypeName» «GenerationUtil.getEntityLowerName(d)»;
			
			«IF d.hasLinearDataConversionWithInterval»
			/*
			«IF d.description != null» * «d.description»
			 * 
			«ENDIF» 
«««			 * Unit: «d.unit»
			 * Adjusted
			 */
			private «d.getDataConversionType.toTypeName» «GenerationUtil.getEntityLowerName(d)»Adjusted;
			«ENDIF»
		'''
	}

	/**
	 * Generates the fields for the non measurement data
	 */
	def generateDataFields(NonMeasurementData d) {
		if (d.constant) {
			'''
				«IF d.description != null»
				/*
				 *«d.description»
				 «IF d.dataType.isUnsigned» 
				 *
				 * Java has no option for unsigned data types, so if the data has an 
				 * unsigned data type the value is calculated by subtracting the maximum 
				 * value from the signed data type and adding it again, if it is used.
				 *
				«ENDIF»
				 */
				«ENDIF» 
				private «d.toTypeName» «d.name.toUpperCase» = «IF d.dataType.isUnsigned»(«d.toSimpleTypeName») («d.value» - «d.toTypeName».MAX_VALUE)«ELSE»«IF d.dataType == DataType.STRING»«d.value»«ELSE»«d.formatedValue»«ENDIF»«ENDIF»;
			'''
		} else {
			'''
				«IF d.description != null»
				 /*
				  *«d.description»
				  */
				«ENDIF» 
				private «d.toTypeName» «GenerationUtil.getEntityLowerName(d)»«IF !d.value.nullOrEmpty» = «IF d.dataType == DataType.STRING»«d.value»«ELSE»«d.formatedValue»«ENDIF»«ENDIF»;
			'''
		}

	}
	
	private def getFormatedValue(NonMeasurementData data) {
		var value = data.value;
		
		if (data.toTypeName.equals(Long.name)) {
			value += LONG_FORMATTED
		}
		
		if (data.toTypeName.equals(Float.name)) {
			value += FLOAT_FORMATTED
		}
		
		if (data.toTypeName.equals(Double.name)) {
			value += DOUBLE_FORMATTED;
		}
		
		value;
	}
	
		/**
	 * Maps to the corresponding language data type.
	 * @see IDTOGenerator#toTypeName(Data)
	 */
	def toTypeName(Data d) {
		return toTypeName(d.dataType)
	}
	
	
	/**
	 * return the type of the list
	 */
	def getListType(ListData data){
		if (data.dataType != DataType.UNDEFINED){
			return data.dataType.toTypeName
		} else if (data.dataTypeDataSet != null){
			return data.dataTypeDataSet.name
		}
	}
		/**
	 * returns the appropriate type name for DataType
	 */
	def toTypeName(DataType d) {
		return switch (d) {
			case INT8: Byte.name
			case UINT8: Byte.name
			case INT16: Short.name
			case UINT16: Short.name
			case INT32: Integer.name
			case UINT32: Integer.name
			case INT64: Long.name
			case UINT64: Long.name
			case FLOAT: Float.name
			case DOUBLE: Double.name
			case BOOLEAN: Boolean.name
			case STRING: String.name
			default: ""
		}
	}
	
	/**
	 * returns the appropriate simple type name suitable for casting
	 */
	def toSimpleTypeName(Data d){
		return toSimpleTypeName(d.dataType)
	}
	
	/**
	 * returns the appropriate simple type name suitable for casting for dataType
	 */
	def toSimpleTypeName(DataType d){
		return switch (d) {
			case INT8: "byte"
			case UINT8: "byte"
			case INT16: "short"
			case UINT16: "short"
			case INT32: "int"
			case UINT32: "int"
			case INT64: "long"
			case UINT64: "long"
			case FLOAT: "float"
			case DOUBLE: "double"
			case BOOLEAN: "boolean"
			case STRING: "String"
			default: ""
		}
	}
	/**
	 * returns true if the DataType is an unsigned DataType
	 */
	def isUnsigned(DataType d){
		if (d == DataType.UINT8 || d == DataType.UINT16 || d == DataType.UINT32 ||d == DataType.UINT64 ){
			return true
		}
		return false
	}
	
	/** 
	 * returns the Data Conversion type (at the moment 
	 * only LinearDataConversionWithIntervall has a type)
	 * 
	 */
	def getDataConversionType(MeasurementData d){
		if (d.adjustments.empty){
			return null
		}
		var conversion = d.adjustments.filter(LinearDataConversionWithInterval);
		if (conversion.empty || conversion == null){
			return null
		}
		return conversion.head.dataType
	}
	
	/**
	 * @return true if the MeasurementData is adjusted 
	 * with linear data conversion with interval
	 */
	def hasLinearDataConversionWithInterval(MeasurementData data){
		return !data.adjustments.filter(LinearDataConversionWithInterval).empty
	}
	
	
}