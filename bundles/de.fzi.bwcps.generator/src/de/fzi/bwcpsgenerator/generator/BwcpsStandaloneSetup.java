package de.fzi.bwcpsgenerator.generator;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;
import de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage;

public class BwcpsStandaloneSetup {
	
	public void register() {
		entityPackage.eINSTANCE.eClass();
		operationsPackage.eINSTANCE.eClass();
		Map<String, Object> m = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		m.put("entity", new XMIResourceFactoryImpl());
		m.put("operations", new XMIResourceFactoryImpl());
	}
}
