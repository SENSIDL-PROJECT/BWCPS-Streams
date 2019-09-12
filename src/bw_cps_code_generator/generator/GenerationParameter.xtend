package bw_cps_code_generator.generator

import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess

class GenerationParameter {
	
	private val Resource input
	private val IFileSystemAccess fileSystemAccess
	private val GenerationLanguage generationLanguage
	
	new(Resource input, IFileSystemAccess fileSystemAccess, GenerationLanguage generationLanguage) {
		
		this.input = input
		this.fileSystemAccess = fileSystemAccess
		this.generationLanguage = generationLanguage
		
	}
	
	public def Resource getResource() {
		
		return this.input
		
	}
	
	public def getFileSystemAccess() {
		
		return this.fileSystemAccess
		
	}
	
	public def getGenerationLanguage() {
		
		return this.generationLanguage
		
	}
	
}
