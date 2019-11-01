package bw_cps_code_generator.generator

class BwCPSConstants {
	public static val JAVA_EXTENSION = ".java"
	public static val JAVA_PROJECT_PACKAGE_PATH = "src/de/fzi/bwcps/generator/"
	public static val JAVA_PROJECT_PACKAGE_PREFIX = "de.fzi.bwcps.generator."
    public static val NODECONFIG_Project_NAME ="NodeConfiguration"
	enum GenerationLanguage {
		NONE,
		ALL,
		OSGI_BUNDLES,
		KURA_BUNDLES,
		JAVA
	}
}
