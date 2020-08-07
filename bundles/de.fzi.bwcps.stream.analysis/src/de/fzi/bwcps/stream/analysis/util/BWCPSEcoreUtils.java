package de.fzi.bwcps.stream.analysis.util;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;

public class BWCPSEcoreUtils {
	
	/**
	 * Adds an ECrossReferenceAdapter to the resource of the given EObject if none can be found
	 * on the resource.
	 * @param any EObject of the target resource
	 */
	public static void applyECrossReferenceAdapter(EObject any) {
		if (any != null && ECrossReferenceAdapter.getCrossReferenceAdapter(any) == null) {
			// Add cross references adapter to resource set resolve inverse cross references
			any.eResource().getResourceSet().eAdapters().add(new ECrossReferenceAdapter());
		}
	}
	
	public static Collection<Setting> getInverseReferences(EObject eObject) {
		  ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter
		    .getCrossReferenceAdapter(eObject);
		  return crossReferenceAdapter == null
		    ? Collections.<Setting> emptyList()
		    : crossReferenceAdapter.getInverseReferences(eObject, true);
	}
}
