package de.fzi.bwcpsgenerator.generator.factory.sidl

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import de.fzi.bwcpsgenerator.generator.BwCPSConstants
import de.fzi.bwcpsgenerator.generator.BwCPSExtentions
import de.fzi.sensidl.design.sensidl.SensorInterface
import java.util.ArrayList
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * 
 *  The SidlGenerator represents a concrete implementation of The ICodeGenerator and implements the 
 * code-generator for the sidl file.
 * @author Sven Eckhardt
 */
class SidlGenerator {

	val static logger = Logger.getLogger(SidlGenerator)

	def generate(NamedElement element) {
		val streamRepo = element as StreamRepository
		val nodeTypes = streamRepo.nodeTypes
		val List<String> generatedData = new ArrayList

		if (nodeTypes !== null && !nodeTypes.empty) {
			logger.info("Invoke SensIDL GenerationHandler")
			// iterate through input data of all node types
			for (d : nodeTypes.map[n|n.input]) {
				var uri = EcoreUtil.getURI(d.get(0))
				if (uri.fileExtension.equals(BwCPSExtentions.SENSIDL.extension)) {
					uri = uri.trimFileExtension.appendFileExtension(BwCPSExtentions.SIDL.extension)
				}
				if (!generatedData.contains(uri.devicePath)) {
					SensIDLInvoker.generate(
						ResourcesPlugin.workspace.root.location + "/" + BwCPSConstants.NODECONFIG_Project_NAME +
							"/src/" + (d.get(0).dataSet.eContainer.eContainer as SensorInterface).name, uri.devicePath)
					generatedData.add(uri.devicePath)
				}
			}
			// iterate through output data of all node types
			for (d : nodeTypes.map[n|n.output]) {
				var uri = EcoreUtil.getURI(d.get(0))
				if (uri.fileExtension.equals(BwCPSExtentions.SENSIDL.extension)) {
					uri = uri.trimFileExtension.appendFileExtension(BwCPSExtentions.SIDL.extension)
				}
				if (!generatedData.contains(uri.devicePath)) {
					SensIDLInvoker.generate(
						ResourcesPlugin.workspace.root.location + "/" + BwCPSConstants.NODECONFIG_Project_NAME +
							"/src/" + (d.get(0).dataSet.eContainer.eContainer as SensorInterface).name, uri.devicePath)
					generatedData.add(uri.devicePath)
				}
			}

		}

	}

}
