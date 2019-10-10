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
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository

class GenerationJobFactory {
	
	public static def getGenerationJobBy(GenerationParameter parameter) {
		
		return switch(parameter.generationLanguage) {
			case GenerationLanguage.KURA_PROJECT: return getKuraProjectGenerationJobBy(parameter)
			default: getDTOGenerationJobBy(parameter)
		}
	}
	
	private def static getKuraProjectGenerationJobBy(GenerationParameter parameter) {
		
		makeGlobalSettings(parameter)
		val generationChain = new LinkedHashSet<GenerationStep>()
		(new StreamRepositoryFilter(parameter.resource).filterData() as StreamRepository).container.forEach[c | 
			{
				generationChain => [
					add(new ProjectGenerationStep(c, parameter.fileSystemAccess))
					add(new DTOGenerationStep(c))
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
			add(new DTOGenerationStep(new StreamRepositoryFilter(parameter.resource)))
			add(new FileGenerationStep(parameter.fileSystemAccess))
		] 
		
		new GenerationJob(generationChain)
		
	}
	
	
	private static def makeGlobalSettings(GenerationParameter parameter) {
		
		GenerationStep.globalSettings = parameter.generationLanguage		
	}
	
}
