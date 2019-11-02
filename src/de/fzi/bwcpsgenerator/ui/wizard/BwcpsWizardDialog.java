package de.fzi.bwcpsgenerator.ui.wizard;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;


public class BwcpsWizardDialog extends WizardDialog {
	/**
	 * Constructor
	 * 
	 * @param parentShell
	 *            the parent Shell
	 * @param newWizard
	 *            the new Wizard to set, must be a BwcpsWizard
	 */
	public BwcpsWizardDialog(Shell parentShell, BwcpsWizard newWizard) {
		super(parentShell, newWizard);
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);

		Button finish = getButton(IDialogConstants.FINISH_ID);
		finish.setText("Generate Code");
		setButtonLayoutData(finish);
	}
}
