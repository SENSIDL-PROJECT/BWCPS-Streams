package bw_cps_code_generator.generator.generationstep


import java.util.HashMap
import java.util.List
import org.eclipse.emf.ecore.EObject

/**
 * The UtilityGenerationStep is a concrete subclass of the GenerationStep class. 
 * The main task of the class is to generate a utility class for a specific generation 
 * language. The utility class is used to store different functionalities to reduce the 
 * complexity of other generated classes.
 */
class UtilityGenerationStep extends GenerationStep {
//	private val List<EObject> data;
//	
//	/**
//	 * The constructor calls the needed data filtered by a concrete element-filter.
//	 * @param filter Represents a base filter which can be substituted by a specific 
//	 * 				 subclass that filters a particular set of elements.
//	 */
//	new(ElementFilter filter) {
//		this.data = filter.filterData
//	}
//	
	/**
	 * @see GenerationStep#startGenerationTask()
	 */
	override startGenerationTask() {
//		if (this.data.size <= 0) {
//			return
//		}
//		
//		this.resourcesToGenerateMapping.get(generationLanguage).execute
	}
//	
//	/**
//	 * Initializes a HashMap that maps each {@link GenerationLanguage} to a
//	 * {@link IExecuter} object.
//	 * @return the HashMap {@link GenerationLanguage} to {@link IExecuter}
//	 */
//	private def getResourcesToGenerateMapping() {
//		return new HashMap<GenerationLanguage, IExecuter> => [
//			put(GenerationLanguage.ALL, [
//				val jgenerator = new JavaGenerator(javaPackagePrefix)
//				filesToGenerate => [putAll(jgenerator.generateUtilityClass(this.data))]
//			])
//			
//			put(GenerationLanguage.JAVA, [
//				val generator = new JavaGenerator(javaPackagePrefix)
//				filesToGenerate => [putAll(generator.generateUtilityClass(this.data))]
//			])
//			
//			
//			put(GenerationLanguage.NONE, [	
//			])
//			
//		]
//	}
}
