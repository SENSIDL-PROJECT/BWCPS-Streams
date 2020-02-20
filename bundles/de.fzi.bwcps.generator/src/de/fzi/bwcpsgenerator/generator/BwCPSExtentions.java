package de.fzi.bwcpsgenerator.generator;


import java.util.Arrays;

public enum BwCPSExtentions {
	
		SENSIDL("sensidl"),
		SIDL("sidl"), 
		ENTITY("entity"), 
		OPERATIONS("operations");
		
		private String extension;
		
		BwCPSExtentions(String extension) {
			this.extension=extension;
		}
		
		public String getExtension() {
			return extension ;
		}
		
		public String getExtensionWithPoint() {
			return "." + extension;
		}

		public static boolean contains(String given) {

		    for (BwCPSExtentions c : BwCPSExtentions.values()) {
		        if (c.getExtension().equals(given)) {
		            return true;
		        }
		    }

		    return false;
		}

		public static String[] getBwCPSExtentions() {
			return Arrays.stream(BwCPSExtentions.values()).map(BwCPSExtentions::getExtension).toArray(String[]::new);
		}
}
