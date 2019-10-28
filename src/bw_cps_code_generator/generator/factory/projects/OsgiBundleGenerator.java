package bw_cps_code_generator.generator.factory.projects;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import bw_cps_code_generator.exception.ExistingProjectException;
import bw_cps_code_generator.generator.BwCPSConstants;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;

/**
 * Creates a Java Plug-in Project at the root of the workspace
 * 
 * @author Sven Eckhardt
 */
public class OsgiBundleGenerator extends ProjectGenerator {

	private String projectName;


	/**
	 * The Constructor.
	 * 
	 * @param projectName - Specifies the name of the generated project.
	 */
	public OsgiBundleGenerator(String projectName) {

		this.projectName = projectName;
	}



	/**
	 * Create a Java Plug-in Project with the given name.
	 * 
	 * @param projectName The name for the java plug-in project
	 * @return the plug-in project
	 * @throws CoreException
	 * @throws IOException
	 */
	public IProject createProject() throws Exception {
		// get project on workspace
		IProject project = null;

		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		project = workspace.getRoot().getProject(projectName);

		// Remove old project if there is one with the same name. Show a Message
		// Dialog if the old project will be deleted
		if (project.exists()) {

			if (this.deleteExistingProjectWith(projectName)) {
				project.delete(true, true, null);
			} else {
				throw new ExistingProjectException(projectName);
			}

		}

		// create Java project
		IJavaProject javaProject = JavaCore.create(project);

		IProjectDescription projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(projectName);
		projectDescription.setLocation(null);
		project.create(projectDescription, null);
		// set Nature (Java and Plug-in Nature)
		projectDescription.setNatureIds(new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature" });
		project.open(null);
		project.setDescription(projectDescription, null);

		projectPath = project.getLocation().toOSString();

		// create src folder
		IFolder srcFolder = project.getFolder("src");
		if (!srcFolder.exists()) {
			srcFolder.create(false, true, null);
		}

		// add classpath entries
		List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
		IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(srcFolder.getFullPath());
		classpathEntries.add(0, srcClasspathEntry);

		classpathEntries.add(JavaCore.newContainerEntry(new Path(
				"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5")));
		classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));

		// set classpath entries
		javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]), null);

		// set bin folder
		javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), null);
		// create Manifest.MF
		createManifest(projectName, project);
		// create build.properties
		createBuildProperties(project, "src");

		return project;
	}

	/*
	 * creates the MANIFEST.MF
	 */
	private void createManifest(String projectName, IProject project) throws CoreException, IOException {
		StringBuilder content = new StringBuilder("Manifest-Version: 1.0\n");
		content.append("Bundle-ManifestVersion: 2\n");
		content.append("Bundle-Name: " + projectName + "\n");
		content.append("Bundle-SymbolicName: " + BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX + projectName.replaceAll(" ", "").toLowerCase() + "; singleton:=true\n");
		content.append("Bundle-Version: 1.0.0.qualifier\n");
		content.append("Bundle-RequiredExecutionEnvironment: JavaSE-1.8\n");
		content.append("Require-Bundle: org.eclipse.osgi.services;bundle-version=\"3.8.0\",\n"
				+ " org.slf4j.api;bundle-version=\"1.7.2\",\n" + " org.junit,\n" + " " + BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX +"nodeconfiguration\n");
		content.append("Export-Package: " + BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX + projectName.replaceAll(" ", "").toLowerCase() + "\n");
		IFolder metaInf = project.getFolder("META-INF");
		metaInf.create(false, true, null);
		createFile("MANIFEST.MF", metaInf, content.toString());
	}

	/*
	 * create build.properties
	 */
	private void createBuildProperties(IProject project, String srcFolder) throws CoreException, IOException {
		StringBuilder content = new StringBuilder("source.. = " + srcFolder + "/");
		content.append("\n");
		content.append("bin.includes = META-INF/,\\\n.");
		createFile("build.properties", project, content.toString());
	}

	/*
	 * creates a file from the given parameters
	 */
	private IFile createFile(String name, IContainer container, String content) throws CoreException, IOException {
		IFile file = container.getFile(new Path(name));
		createDirectory(file.getParent());

		InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
		if (file.exists()) {
			file.setContents(stream, true, true, null);
		} else {
			file.create(stream, true, null);
		}
		stream.close();

		return file;
	}

	/*
	 * creates non-existing directories recursively
	 */
	private void createDirectory(IContainer container) throws CoreException {
		if (!container.exists()) {
			if (!container.getParent().exists()) {
				createDirectory(container.getParent());
			}
			if (container instanceof IFolder) {
				((IFolder) container).create(false, true, null);
			}
		}
	}

	protected boolean deleteExistingProjectWith(final String name) {

		final boolean[] result = new boolean[1];
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				result[0] = MessageDialog.openQuestion(new Shell(), "'" + name + "'" + "already exists",
						"Warning: " + "'" + name + "' already exists. Should this project be deleted?");
			}
		});

		return result[0];

	}
}
