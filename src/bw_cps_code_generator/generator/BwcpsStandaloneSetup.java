package bw_cps_code_generator.generator;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.ISetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage;
import de.fzi.bwcps.stream.bwcps_streams.entity.impl.entityFactoryImpl;
import de.fzi.bwcps.stream.bwcps_streams.operations.operationsPackage;
import de.fzi.bwcps.stream.bwcps_streams.operations.impl.operationsFactoryImpl;

public class BwcpsStandaloneSetup {
	
	public Injector createInjectorAndDoEMFRegistration() {
		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();
		Injector injector = Guice.createInjector(new BwcpsRuntimeModule());;
		register();
		return injector;
	}

	public void register() {
		//TODO why necessary
//		org.eclipse.xtext.common.TerminalsStandaloneSetup.doSetup();
		entityPackage.eINSTANCE.eClass();
		operationsPackage.eINSTANCE.eClass();
		Map<String, Object> m = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		m.put("entity", new XMIResourceFactoryImpl());
		m.put("operations", new operationsFactoryImpl());
	}
}
