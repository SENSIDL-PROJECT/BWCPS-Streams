package de.fzi.bwcpsgenerator.generator

class BwCPSConstants {
	public static val JAVA_EXTENSION = ".java"
	public static val JAVA_PROJECT_PACKAGE_PATH = "src/de/fzi/bwcps/generator/"
	public static val JAVA_PROJECT_PACKAGE_PREFIX = "de.fzi.bwcps.generator."
    public static val NODECONFIG_Project_NAME ="NodeConfiguration"
	public static val BUNDLE_NAME = "bw-cps-generator"
	enum GenerationLanguage {
		NONE,
		ALL,
		OSGI_BUNDLES,
		KURA_BUNDLES,
		JAVA
	}
}
