package de.fzi.bwcps.stream.analysis.util;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

public class BWCPSEcoreUtils {
	public static Collection<Setting> getInverseReferences(EObject eObject) {
		  ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter
		    .getCrossReferenceAdapter(eObject);
		  return crossReferenceAdapter == null
		    ? Collections.<Setting> emptyList()
		    : crossReferenceAdapter.getInverseReferences(eObject, true);
	}
}
