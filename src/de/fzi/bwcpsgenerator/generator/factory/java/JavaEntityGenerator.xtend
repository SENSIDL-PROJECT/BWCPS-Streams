package de.fzi.bwcpsgenerator.generator.factory.java

import de.fzi.bwcpsgenerator.generator.BwCPSConstants
import de.fzi.bwcpsgenerator.generator.factory.IDTOGenerator

abstract class JavaEntityGenerator implements IDTOGenerator {

	override addFileExtensionTo(String className) {
		return className + BwCPSConstants.JAVA_EXTENSION
	}
}
