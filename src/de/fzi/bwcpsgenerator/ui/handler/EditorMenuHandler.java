package de.fzi.bwcpsgenerator.ui.handler;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.fzi.bwcpsgenerator.ui.wizard.BwcpsWizard;
import de.fzi.bwcpsgenerator.ui.wizard.BwcpsWizardDialog;

public class EditorMenuHandler extends AbstractHandler implements IHandler {
	private String path;
	private String language;
	private String modelPath;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// get Model Path
		IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);

		IFile file = (IFile) activeEditor.getEditorInput().getAdapter(IFile.class);

		modelPath = "platform:/resource" + file.getFullPath().toString();

		// load Settings, if there are any
		loadSettings();

		// open Wizard with ModelPath, Path and language as parameter
		BwcpsWizard swizard = new BwcpsWizard(modelPath, path, language, null);
		BwcpsWizardDialog dialog = new BwcpsWizardDialog(HandlerUtil.getActiveShell(event), swizard);
		dialog.open();

		return null;
	}

	/*
	 * Load the Settings that are the path and the generation language
	 */
	private void loadSettings() {
		path = SettingsHandler.loadPathSettings();
		language = SettingsHandler.loadLanguageSettings();
	}

}
