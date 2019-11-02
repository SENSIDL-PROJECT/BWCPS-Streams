package de.fzi.bwcpsgenerator.generator.metamodelmanager

import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.edit.ui.EMFEditUIPlugin
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.PlatformUI

/**
 * This class represents the superclass for particular element-filters.
 */
abstract class ElementManager {
	protected var Resource input;

	new(Resource input) {
		this.input = input
	}
	/**
	 * This abstract method has to be implemented by a subclass which is 
	 * up to filter a particular collection of sensidl-elements.
	 * @return the list of the filtered data.
	 */
	abstract def <T> T filterData()
	
	def protected boolean displayWarning(String entity) {
		val boolean[] continue = newBooleanArrayOfSize(1) 
		PlatformUI.getWorkbench().getDisplay().syncExec(
			[{ val result = continue result.set(0,MessageDialog.openQuestion(new Shell(), 
				'''Multiple «entity»s''', 
				'''
					Warning: Multiple «entity». Only the first one would be further considered for generation. 
							 Continue generation Process?
					'''
			))} ]
		) 
		return continue.get(0) 
	}
	protected def handleDiagnostic (Diagnostic diagnostic) {
		var int severity = diagnostic.getSeverity()
		if (severity === Diagnostic.ERROR || severity === Diagnostic.WARNING) {
			var String title = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_title")
			var String message = EMFEditUIPlugin.INSTANCE.getString("_UI_ValidationProblems_message")
			DiagnosticDialog.open(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), title,
				message, diagnostic)
			return false
		} 
		true
	}
}
