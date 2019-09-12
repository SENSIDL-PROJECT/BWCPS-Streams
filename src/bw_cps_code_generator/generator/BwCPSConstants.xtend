package bw_cps_code_generator.generator

class BwCPSConstants {
	public static val JAVA_EXTENSION = ".java"
	public static val JAVA_PROJECT_PACKAGE_PATH = "src/bw-cps-code-generator/"
	public static val JAVA_PROJECT_PACKAGE_PREFIX = "bw_cps_code_generator."
	public static val JAVA_DEFAULT_PACKAGE_PREFIX = ""

	public enum GenerationLanguage {
		NONE,
		ALL,
		MAVEN_PROJECT,
		JAVA
	}
}
