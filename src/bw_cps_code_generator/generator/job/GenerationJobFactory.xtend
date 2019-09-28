package bw_cps_code_generator.generator.job

import java.util.LinkedHashSet

import static bw_cps_code_generator.generator.generationstep.GenerationStep.*
import bw_cps_code_generator.generator.GenerationParameter
import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import bw_cps_code_generator.generator.generationstep.GenerationStep
import bw_cps_code_generator.generator.generationstep.DTOGenerationStep
import bw_cps_code_generator.generator.generationstep.DeploymentPackageGenerationStep
import bw_cps_code_generator.generator.generationstep.FileGenerationStep
import bw_cps_code_generator.generator.elementfilter.StreamRepositoryFilter
import bw_cps_code_generator.generator.elementfilter.ElementFilter
import bw_cps_code_generator.generator.generationstep.ProjectGenerationStep
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import bw_cps_code_generator.generator.elementfilter.NodeContainerFilter
import java.util.List
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository

class GenerationJobFactory {
	
	public static def getGenerationJobBy(GenerationParameter parameter) {
		
		return switch(parameter.generationLanguage) {
			case GenerationLanguage.KURA_PROJECT: return getKuraProjectGenerationJobBy(parameter)
//			case GenerationLanguage.MAVEN_PROJECT: return getMavenGenerationJobBy(parameter)
			default: getDTOGenerationJobBy(parameter)
		}
	}
	
	private def static getKuraProjectGenerationJobBy(GenerationParameter parameter) {
		
		makeGlobalSettings(parameter)
		val generationChain = new LinkedHashSet<GenerationStep>()
		(new StreamRepositoryFilter().filterData() as StreamRepository).container.forEach[c | 
			{
				generationChain => [
					add(new ProjectGenerationStep(c, parameter.fileSystemAccess))
					add(new DTOGenerationStep(c))
//					add(new UtilityGenerationStep(new UtilityDataFilter()))
					add(new FileGenerationStep(parameter.fileSystemAccess))
					add(new DeploymentPackageGenerationStep(new StreamRepositoryFilter(), parameter.fileSystemAccess))
				]
			}
		]
		
		new GenerationJob(generationChain)
	}
	
//	private def static getMavenGenerationJobBy(GenerationParameter parameter) {
//		//TODO MAVEN??
//		makeGlobalSettings(parameter)
//		
//		val generationChain = new LinkedHashSet<GenerationStep> => [
//			add(new ProjectGenerationStep(new StreamRepositoryFilter(), parameter.fileSystemAccess))
//			add(new DTOGenerationStep(new StreamRepositoryFilter()))
////			add(new UtilityGenerationStep(new UtilityDataFilter()))
//			add(new FileGenerationStep(parameter.fileSystemAccess))
//		] 
//		
//		new GenerationJob(generationChain)
//		
//	}
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
