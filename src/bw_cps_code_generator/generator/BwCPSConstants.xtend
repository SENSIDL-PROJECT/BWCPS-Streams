package bw_cps_code_generator.generator

class BwCPSConstants {
	public static val JAVA_EXTENSION = ".java"
	public static val JAVA_PROJECT_PACKAGE_PATH = "src/de/fzi/bwcps/generator/"
	public static val JAVA_PROJECT_PACKAGE_PREFIX = "de.fzi.bwcps.generator."
	public static val JAVA_DEFAULT_PACKAGE_PREFIX = ""

	public enum GenerationLanguage {
		NONE,
		ALL,
		OSGI_BUNDLES,
		JAVA
	}
}
