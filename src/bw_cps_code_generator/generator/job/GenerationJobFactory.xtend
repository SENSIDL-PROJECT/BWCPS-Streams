package bw_cps_code_generator.generator.job

import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import bw_cps_code_generator.generator.GenerationParameter
import bw_cps_code_generator.generator.generationstep.DTOGenerationStep
import bw_cps_code_generator.generator.generationstep.FileGenerationStep
import bw_cps_code_generator.generator.generationstep.GenerationStep
import java.util.LinkedHashSet

import static bw_cps_code_generator.generator.generationstep.GenerationStep.*
import bw_cps_code_generator.generator.generationstep.ProjectGenerationStep
import bw_cps_code_generator.generator.generationstep.NodeConfigurationGenerationStep
import bw_cps_code_generator.generator.metamodelmanager.StreamRepositoryManager

class GenerationJobFactory {
	
	public static def getGenerationJobBy(GenerationParameter parameter) {
		
		return switch(parameter.generationLanguage) {
			case GenerationLanguage.OSGI_BUNDLES: return getKuraProjectGenerationJobBy(parameter)
			default: getDTOGenerationJobBy(parameter)
		}
	}
	
	private def static getKuraProjectGenerationJobBy(GenerationParameter parameter) {
		
		makeGlobalSettings(parameter)
		val generationChain = new LinkedHashSet<GenerationStep>()
		val streamRepo = new StreamRepositoryManager(parameter.resource).filterData()

		generationChain.add(new NodeConfigurationGenerationStep(parameter.fileSystemAccess, StreamRepositoryManager.needsSecurityPackage(streamRepo)))

		streamRepo.container.forEach[c | 
			{
				generationChain => [
					add(new ProjectGenerationStep(c, parameter.fileSystemAccess))
					add(new DTOGenerationStep(c, StreamRepositoryManager.filterNodelinksOnNodeContainer(streamRepo, c)))
					add(new FileGenerationStep(c, parameter.fileSystemAccess))
//					add(new DeploymentPackageGenerationStep(new StreamRepositoryFilter(), parameter.fileSystemAccess))
				]
			}
		]
		
		new GenerationJob(generationChain)
	}
	
	public static def getDTOGenerationJobBy(GenerationParameter parameter) {
		
				
		makeGlobalSettings(parameter)
		
		val generationChain = new LinkedHashSet<GenerationStep> => [
			add(new DTOGenerationStep(new StreamRepositoryManager(parameter.resource)))
			add(new FileGenerationStep(parameter.fileSystemAccess))
		] 
		
		new GenerationJob(generationChain)
		
	}
	
	
	private static def makeGlobalSettings(GenerationParameter parameter) {
		
		GenerationStep.globalSettings = parameter.generationLanguage		
	}

}
