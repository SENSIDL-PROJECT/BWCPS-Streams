package de.fzi.bwcpsgenerator.generator.metamodel

import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import org.eclipse.emf.ecore.resource.Resource
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer
import java.util.stream.Collectors
import de.fzi.bwcps.stream.bwcps_streams.entity.SecurityMeasure
import de.fzi.bwcpsgenerator.exception.MetamodelException
import org.eclipse.emf.ecore.util.Diagnostician
import de.fzi.bwcpsgenerator.generator.GenerationUtil
import de.fzi.bwcps.stream.bwcps_streams.entity.Node

class StreamRepositoryManager extends ElementManager {

	/**
	 * Implements the abstract method of the base-class and filters the SensorInterface-elements.
	 * @see ElementFilter#filterData()
	 */
	new(Resource input) {
		super(input)
	}

	override StreamRepository filterData() {
		// Exception
		val repos = input.contents.filter(StreamRepository)
		if (repos.length <= 0) {
			throw new MetamodelException("A Bwcps-metamodel should contain at least one stream repository")
		}
		if (repos.length > 1) {
			if (!displayWarning("stream repositories")) {
				throw new MetamodelException("Multiple stream repositories. Generation Process aborted.")
			}
		}

		val streamRepo = input.contents.filter(StreamRepository).get(0)
		
		if (!handleDiagnostic(Diagnostician.INSTANCE.validate(streamRepo))) {
			throw new MetamodelException("Please fix the mentioned problems then try again.")
		}
		
		streamRepo
	}

	static def filterNodelinksOnNodeContainer(StreamRepository streamRepo, NodeContainer nodeContainer) {
		streamRepo.streams.stream.map(
			stream |
				stream.nodelinks.filter [ nodelink |
					nodeContainer.nodes.contains(nodelink.source) || nodeContainer.nodes.contains(nodelink.target)
				]
		).flatMap(l|l.toList.stream).collect(Collectors.toList());
	}

	static def filterNeededBundlesForNodeContainer(StreamRepository streamRepo, NodeContainer nodeContainer) {
		streamRepo.streams.stream.map(
			stream |
				stream.nodelinks.filter [ nodelink |
					nodeContainer.nodes.contains(nodelink.target)
				]
		).flatMap(l|l.toList.stream).collect(Collectors.toList())
		.stream
		.map(nodelink | GenerationUtil.getEntityLowerName(getNodeContainerOfNode(nodelink.source)).toLowerCase)
		.filter(name| !name.equals(GenerationUtil.getEntityLowerName(nodeContainer).toLowerCase))
		.collect(Collectors.toList())
		.stream
		.distinct
		.collect(Collectors.toList())
	}
	
	static def getNodeContainerOfNode(Node node) {
		(node.eContainer as StreamRepository).container.findFirst[c | c.nodes.contains(node)]
	}
	
	static def needsSecurityPackage(StreamRepository streamRepo) {
		streamRepo.streams.stream.anyMatch(
			stream |
				stream.nodelinks.exists[nodelink|nodelink.securityMeasure != SecurityMeasure.NONE]
		)
	}
}
