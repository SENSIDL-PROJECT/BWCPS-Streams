package de.fzi.bwcpsgenerator.generator

import de.fzi.bwcpsgenerator.generator.BwCPSConstants.GenerationLanguage
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import de.fzi.bwcpsgenerator.generator.job.GenerationJobFactory
import javax.naming.OperationNotSupportedException

class BwcpsGenerator implements IGenerator {

	static Logger logger = Logger.getLogger(BwcpsGenerator);

	GenerationLanguage generationLanguage = GenerationLanguage.ALL

	override doGenerate(Resource input, IFileSystemAccess fsa) {
		setUpLogger()
		
		val generationJob = GenerationJobFactory.getGenerationJobBy(new GenerationParameter(input, fsa, generationLanguage));

		try {
			
			logger.info("Start with code-generation.")
			
			generationJob.start
			
		} catch (OperationNotSupportedException e) {
			logger.error("Start to generate code-templates which does not exist.", e)
		} catch (Exception e) {
			logger.error("A error occurred.", e)
		}

	}

	def setUpLogger() {
		var logger = Logger.getLogger(typeof(BwcpsGenerator).package.name)
		logger.setLevel(Level.ALL)
	}
		def setGenerationLanguage(GenerationLanguage generationLanguage) {
		this.generationLanguage = generationLanguage
	}
}
