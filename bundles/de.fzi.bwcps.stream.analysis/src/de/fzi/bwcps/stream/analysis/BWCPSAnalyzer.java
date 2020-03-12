package de.fzi.bwcps.stream.analysis;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;

public class BWCPSAnalyzer {
	public void start(NamedElement startingPoint) {
		System.out.println(startingPoint);
		Notifier rootObj = EcoreUtil.getRootContainer(startingPoint, true);
		if (rootObj instanceof StreamRepository) {
			EObject root = (EObject) rootObj;
		}
		
	}
}
