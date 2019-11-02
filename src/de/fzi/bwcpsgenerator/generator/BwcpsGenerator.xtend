package de.fzi.bwcpsgenerator.generator

import de.fzi.bwcpsgenerator.generator.BwCPSConstants.GenerationLanguage
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

class BwcpsGenerator implements IGenerator {

	BwcpsCodeGenerationExecutor codeGenerator;
	static Logger logger = Logger.getLogger(BwcpsGenerator);

	GenerationLanguage generationLanguage = GenerationLanguage.ALL

	new () {
		this.codeGenerator = new BwcpsCodeGenerationExecutor;
	}
	override doGenerate(Resource resource, IFileSystemAccess fsa) {
		setUpLogger()

		codeGenerator.generationLanguage = generationLanguage
		codeGenerator.doGenerate(resource, fsa)
		
		logger.info("Code was generated")

	}

	def setUpLogger() {
		var logger = Logger.getLogger(typeof(BwcpsGenerator).package.name)
		logger.setLevel(Level.ALL)
	}
		def setGenerationLanguage(GenerationLanguage generationLanguage) {
		this.generationLanguage = generationLanguage
	}
}
