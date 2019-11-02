package de.fzi.bwcpsgenerator.generator.job

import de.fzi.bwcpsgenerator.generator.BwCPSConstants.GenerationLanguage
import de.fzi.bwcpsgenerator.generator.GenerationParameter
import de.fzi.bwcpsgenerator.generator.generationstep.DTOGenerationStep
import de.fzi.bwcpsgenerator.generator.generationstep.FileGenerationStep
import de.fzi.bwcpsgenerator.generator.generationstep.GenerationStep
import java.util.LinkedHashSet

import static de.fzi.bwcpsgenerator.generator.generationstep.GenerationStep.*
import de.fzi.bwcpsgenerator.generator.generationstep.ProjectGenerationStep
import de.fzi.bwcpsgenerator.generator.generationstep.NodeConfigurationGenerationStep
import de.fzi.bwcpsgenerator.generator.metamodelmanager.StreamRepositoryManager

class GenerationJobFactory {
	
	static def getGenerationJobBy(GenerationParameter parameter) {
		
		return switch(parameter.generationLanguage) {
			case GenerationLanguage.OSGI_BUNDLES,
			case GenerationLanguage.KURA_BUNDLES: 
				return getOsgiProjectsGenerationJobBy(parameter)
			default: getDTOGenerationJobBy(parameter)
		}
	}
	
	private def static getOsgiProjectsGenerationJobBy(GenerationParameter parameter) {
		
		makeGlobalSettings(parameter)
		val generationChain = new LinkedHashSet<GenerationStep>()
		val streamRepo = new StreamRepositoryManager(parameter.resource).filterData()

		generationChain.add(new NodeConfigurationGenerationStep(streamRepo, parameter.fileSystemAccess))
		generationChain.add(new FileGenerationStep( parameter.fileSystemAccess))

		streamRepo.container.forEach[c | 
			{
				generationChain => [
					add(new ProjectGenerationStep(c, parameter.fileSystemAccess, StreamRepositoryManager.filterNeededBundlesForNodeContainer(streamRepo, c)))
					add(new DTOGenerationStep(c, StreamRepositoryManager.filterNodelinksOnNodeContainer(streamRepo, c)))
					add(new FileGenerationStep(parameter.fileSystemAccess))
//					add(new DeploymentPackageGenerationStep(new StreamRepositoryFilter(), parameter.fileSystemAccess))
				]
			}
		]
		
		new GenerationJob(generationChain)
	}
	
	static def getDTOGenerationJobBy(GenerationParameter parameter) {
		
				
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
