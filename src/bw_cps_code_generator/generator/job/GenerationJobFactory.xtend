package bw_cps_code_generator.generator.job

import java.util.LinkedHashSet

import static bw_cps_code_generator.generator.generationstep.GenerationStep.*
import bw_cps_code_generator.generator.GenerationParameter
import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import bw_cps_code_generator.generator.generationstep.GenerationStep
import bw_cps_code_generator.generator.generationstep.DTOGenerationStep
import bw_cps_code_generator.generator.generationstep.UtilityGenerationStep
import bw_cps_code_generator.generator.generationstep.FileGenerationStep
import bw_cps_code_generator.generator.elementfilter.StreamRepositoryFilter
import bw_cps_code_generator.generator.elementfilter.ElementFilter
import bw_cps_code_generator.generator.generationstep.ProjectGenerationStep

class GenerationJobFactory {
	
		public static def getGenerationJobBy(GenerationParameter parameter) {
		
		return switch(parameter.generationLanguage) {
			
			case GenerationLanguage.MAVEN_PROJECT: return getMavenGenerationJobBy(parameter)
			default: getDTOGenerationJobBy(parameter)
			
		}
		
	}
	
	
	private def static getMavenGenerationJobBy(GenerationParameter parameter) {
		
		makeGlobalSettings(parameter)
		
		val generationChain = new LinkedHashSet<GenerationStep> => [
			add(new ProjectGenerationStep(new StreamRepositoryFilter(), parameter.fileSystemAccess))
			add(new DTOGenerationStep(new StreamRepositoryFilter()))
//			add(new UtilityGenerationStep(new UtilityDataFilter()))
			add(new FileGenerationStep(parameter.fileSystemAccess))
		] 
		
		new GenerationJob(generationChain)
		
	}
	public static def getDTOGenerationJobBy(GenerationParameter parameter) {
		
				
		makeGlobalSettings(parameter)
		
		val generationChain = new LinkedHashSet<GenerationStep> => [
			add(new DTOGenerationStep(new StreamRepositoryFilter()))
//			add(new UtilityGenerationStep())
			add(new FileGenerationStep(parameter.fileSystemAccess))
		] 
		
		new GenerationJob(generationChain)
		
	}
	
	
	private static def makeGlobalSettings(GenerationParameter parameter) {
		
		GenerationStep.globalSettings = parameter.generationLanguage
  		ElementFilter.init(parameter.resource)
		
	}
	
}
