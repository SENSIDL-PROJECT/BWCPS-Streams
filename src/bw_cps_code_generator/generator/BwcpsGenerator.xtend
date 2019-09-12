package bw_cps_code_generator.generator

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.apache.log4j.Logger
import org.apache.log4j.Level
import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import com.google.inject.Inject

class BwcpsGenerator implements IGenerator {
//TODO Add a Parser to have a valid Model
//TODO Refactor before generation: add all Nodes to StreamRepo or Node Container 
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
