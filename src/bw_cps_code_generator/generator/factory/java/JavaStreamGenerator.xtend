package bw_cps_code_generator.generator.factory.java

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider
import bw_cps_code_generator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import de.fzi.bwcps.stream.bwcps_streams.entity.Stream
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger

class JavaStreamGenerator extends JavaEntityGenerator {
	static val Logger logger = Logger.getLogger(JavaStreamGenerator)
	val List<Stream> streams

	new(List<Stream> streams) {
		this.streams = streams
	}

	override generate() {
		logger.info("Generate streams.")
		val filesToGenerate = new HashMap
		filesToGenerate.put("Stream.java", generateInterfaceBody(streams))
		logger.info("File: Stream.java was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		for (stream : streams) {
			filesToGenerate.put(addFileExtensionTo(GenerationUtil.getEntityUpperName(stream)),
			generateClassBody(GenerationUtil.getEntityUpperName(stream), stream))
			logger.info("File: " + addFileExtensionTo(GenerationUtil.getEntityUpperName(stream)) + " was generated in " +
			BwcpsOutputConfigurationProvider.BWCPS_GEN)
		}

		filesToGenerate
	}
	
	def generateInterfaceBody(List streams) {
		'''
			package streams;
			import nodes.NodeLink;
			import java.util.List;
						
			/**
			* Stream Interface
			*
			* @generated
			*/
			public interface Stream {
				
				List<NodeLink> getNodelinks;
				
			}
		'''
	}
	
	override generateClassBody(String entityName, NamedElement stream) {
		'''
			package streams;
			
			import streams.Stream;
			import nodes.NodeLink;
			import java.util.List;
			/**
			* Stream: «entityName»
			*
			* @generated
			*/
				
			public class «entityName» implements Stream {
										
				private static final long serialVersionUID = 1L;
				
				«generateDataFields(stream)»
				
				«generateConstructor(stream, entityName)»
				
				
				«stream.generateMethods»
				
				«generateDataMethods(stream)»
				
			}
		'''
	}

	override generateDataMethods(NamedElement entity) {
		//
	}
	override generateConstructor(NamedElement etity, String className) {
		'''
				
			public «className»(List<NodeLink> nodelinks) {
				this.nodelinks = nodelinks;
			}
		'''
	}

	/** 
	 * Generates Methods
	 * 
	 */
	def generateMethods(StreamRepository repo) {
	}
	
	override generateDataFields(NamedElement entity) {
	'''
		private List<NodeLink> nodelinks;
	'''
	}
	
	override generateMethods(NamedElement entity) {
		'''
			@Override
			public List<NodeLink> getNodelinks(){
				return nodelinks;
			}
		'''
	}

}
