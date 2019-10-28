package bw_cps_code_generator.generator.factory.java

import bw_cps_code_generator.generator.BwCPSConstants
import bw_cps_code_generator.generator.factory.IDTOGenerator
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement
import java.util.List

abstract class JavaEntityGenerator implements IDTOGenerator {

	override addFileExtensionTo(String className) {
		return className + BwCPSConstants.JAVA_EXTENSION
	}
}
