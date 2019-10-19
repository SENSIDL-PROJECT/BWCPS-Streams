package bw_cps_code_generator.generator.generationstep


import java.util.HashMap
import java.util.List
import org.eclipse.emf.ecore.EObject
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import bw_cps_code_generator.generator.IExecuter
import bw_cps_code_generator.generator.factory.kuracomponents.JavaComponentGenerator

/**
 * The UtilityGenerationStep is a concrete subclass of the GenerationStep class. 
 * The main task of the class is to generate a utility class for a specific generation 
 * language. The utility class is used to store different functionalities to reduce the 
 * complexity of other generated classes.
 */
class UtilityGenerationStep extends GenerationStep {

	private NamedElement element
	private List<NodeLink> nodelinks
	
	/**
	 * The constructor calls the needed data filtered by a
	 * concrete element-filter.
	 * @param filter - represents a base filter which can be substituted by a specific
	 * 				   subclass that filters a particular set of elements.	
	 */
	new(NodeContainer element, List<NodeLink> nodelinks) {
		this.element = element
		this.nodelinks = nodelinks
	}
	
	/**
	 * @see GenerationStep#startGenerationTask()
	 */
	override startGenerationTask() {
		if (this.nodelinks.size <= 0) {
			return
		}
		
		this.resourcesToGenerateMapping.get(generationLanguage).execute
	}
	
	/**
	 * Initializes a HashMap that maps each {@link GenerationLanguage} to a
	 * {@link IExecuter} object.
	 * @return the HashMap {@link GenerationLanguage} to {@link IExecuter}
	 */
	private def getResourcesToGenerateMapping() {
		return new HashMap<GenerationLanguage, IExecuter> => [
			put(GenerationLanguage.ALL, [
				val JavaComponentGenerator kgenerator = new JavaComponentGenerator(javaPackagePrefix)
				filesToGenerate => [putAll(kgenerator.generateSecurityClasses(this.element as NodeContainer, nodelinks))]
			])
			
			put(GenerationLanguage.KURA_PROJECT, [
				val JavaComponentGenerator kgenerator = new JavaComponentGenerator(javaPackagePrefix)
				resetFilesToGenerate
				filesToGenerate => [
					putAll(kgenerator.generateSecurityClasses(this.element as NodeContainer, nodelinks))
				]
				
			])
			
			put(GenerationLanguage.JAVA, [
			])
						
			put(GenerationLanguage.NONE, [	
			])
			
		]
	}
}
