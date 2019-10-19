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
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.osgi.framework.Bundle;

import bw_cps_code_generator.generator.BwCPSConstants;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;

/**
 * Creates a Java Plug-in Project at the root of the workspace
 * 
 * @author Sven Eckhardt
 */
//TODO NOT SECURITY
public class SecurityProjectGenerator extends ProjectGenerator {

	private String projectName = "NodeConfiguration";





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
				throw new Exception("Project already exist.");
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



		// create src folder
		IFolder srcFolder = project.getFolder("src");
		if (!srcFolder.exists()) {
			srcFolder.create(false, true, null);
		}

		// copy crypto
		Bundle bundle = Platform.getBundle("bw-cps-code-generator");
		Path path = new Path("commons-crypto-1.0.0.jar");
		URL absoluteFileURL = FileLocator.resolve(FileLocator.find(bundle, path, null));

		java.nio.file.Path cryptoSource = java.nio.file.Paths
				.get(absoluteFileURL.toURI());

		java.nio.file.Path cryptoDestination = java.nio.file.Paths
				.get(ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/" + projectName + "/");

		java.nio.file.Files.copy(cryptoSource, cryptoDestination.resolve(cryptoSource.getFileName()),
				java.nio.file.StandardCopyOption.REPLACE_EXISTING);

		// add classpath entries
		List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
		IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(srcFolder.getFullPath());
		classpathEntries.add(0, srcClasspathEntry);

		classpathEntries.add(JavaCore.newContainerEntry(new Path(
				"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5")));
		classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));

		// add crypto to classpathEntries
		File file = new File(cryptoDestination.resolve(cryptoSource.getFileName()).toString());
		classpathEntries.add(JavaCore.newLibraryEntry(Path.fromOSString(file.getAbsolutePath()), null, null));

		// set classpath entries
		javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]), null);

		// set bin folder
		javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), null);
		// create Manifest.MF
		createManifest(projectName, project);
		// create build.properties
		createBuildProperties(project, "src");

		createNodeInterface(project);
		createSecurableNodeInterface(project);
		createSecurityManagerInterface(project);
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
				+ " org.slf4j.api;bundle-version=\"1.7.2\",\n" + " org.junit,\n" + " org.apache.commons.lang;bundle-version=\"2.6.0\"\n");
		content.append("Export-Package: " + BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX + projectName.replaceAll(" ", "").toLowerCase() + ","
				+ BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX + projectName.replaceAll(" ", "").toLowerCase() +".security\n");
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


	private void createNodeInterface(IProject project) throws CoreException, IOException {
		StringBuilder content = new StringBuilder("package "+ BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX + projectName.replaceAll(" ", "").toLowerCase() +";\n" + 
				"\n" + 
				"public interface Node {\n" + 
				"	\n" +
				"	public void establishConnectionTo(Node sourceNode);\n" + 
				"}\n" + 
				"");
		IFolder packageFolder = project.getFolder(BwCPSConstants.JAVA_PROJECT_PACKAGE_PATH + projectName.replaceAll(" ", "").toLowerCase() + "/");
		prepare(packageFolder);
		createFile("Node.java", packageFolder, content.toString());
	}
	
	private void createSecurableNodeInterface(IProject project) throws CoreException, IOException {
		StringBuilder content = new StringBuilder("package "+ BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX + projectName.replaceAll(" ", "").toLowerCase() +";\n" + 
				"\n" + 
				"import java.security.PublicKey;\n" + 
				"\n" + 
				"public interface SecurableNode extends Node{\n" + 
				"	\n" + 
				"	public PublicKey getPublicKey();\n" + 
				"	\n" + 
				//TODO change type
				"	public void receiveEncryptedKey(SecurableNode node, byte[] key);\n" + 
				"	\n" +
				"	public void establishSecureConnectionTo(SecurableNode sourceNode);\n" + 
				"}\n" + 
				"");
		IFolder packageFolder = project.getFolder(BwCPSConstants.JAVA_PROJECT_PACKAGE_PATH + projectName.replaceAll(" ", "").toLowerCase() + "/");
		prepare(packageFolder);
		createFile("SecurableNode.java", packageFolder, content.toString());
	}
	private void createSecurityManagerInterface(IProject project) throws CoreException, IOException {
		StringBuilder content = new StringBuilder("package "+ BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX + projectName.replaceAll(" ", "").toLowerCase() +
				".security" + ";\n" + 
				"import java.io.Serializable;\n" + 
				"import java.security.InvalidAlgorithmParameterException;\n" + 
				"import java.security.InvalidKeyException;\n" + 
				"import java.security.KeyPair;\n" + 
				"import java.security.KeyPairGenerator;\n" + 
				"import java.security.NoSuchAlgorithmException;\n" + 
				"import java.security.PrivateKey;\n" + 
				"import java.security.PublicKey;\n" + 
				"import java.security.SecureRandom;\n" + 
				"import java.util.Base64;\n" + 
				"import java.util.HashMap;\n" + 
				"\n" + 
				"import javax.crypto.BadPaddingException;\n" + 
				"import javax.crypto.Cipher;\n" + 
				"import javax.crypto.IllegalBlockSizeException;\n" + 
				"import javax.crypto.KeyGenerator;\n" + 
				"import javax.crypto.NoSuchPaddingException;\n" + 
				"import javax.crypto.SecretKey;\n" + 
				"import javax.crypto.ShortBufferException;\n" + 
				"import javax.crypto.spec.IvParameterSpec;\n" + 
				"import javax.crypto.spec.SecretKeySpec;\n" + 
				"\n" + 
				"import org.apache.commons.lang.SerializationUtils;\n" + 
				"import org.slf4j.Logger;\n" + 
				"import org.slf4j.LoggerFactory;\n" + 
				"\n" + 
				"import de.fzi.bwcps.generator.nodeconfiguration.Node;\n" + 
				"import de.fzi.bwcps.generator.nodeconfiguration.SecurableNode;\n" + 
				"/**\n" + 
				"* Node: Sensor\n" + 
				"*\n" + 
				"* @generated\n" + 
				"*/\n" + 
				"\n" + 
				"public class SecurityManager  {\n" + 
				"	private static final Logger s_logger = LoggerFactory.getLogger(SecurityManager.class);\n" + 
				"	static final int MIN_OUT_BUFFER_SIZE = 32;\n" + 
				"	private PrivateKey privateKey;\n" + 
				"	\n" + 
				"	private PublicKey publicKey;\n" + 
				"	\n" + 
				"	Cipher cipherAES;\n" + 
				"    IvParameterSpec iv;\n" + 
				"    byte[] IVBytes = new byte[16];\n" + 
				"    SecureRandom random;\n" + 
				"	final String transform = \"AES/CBC/PKCS5Padding\";\n" + 
				"	\n" + 
				"	private HashMap<Node, SecretKey> aesKeys = new HashMap<Node, SecretKey>();\n" + 
				"\n" + 
				"	public SecurityManager() {\n" + 
				"		try {\n" + 
				"			//generate key pair\n" + 
				"			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(\"RSA\");\n" + 
				"			keyGen.initialize(2048);\n" + 
				"			KeyPair keyPair = keyGen.generateKeyPair();\n" + 
				"			\n" + 
				"			privateKey = keyPair.getPrivate();\n" + 
				"			publicKey = keyPair.getPublic();	\n" + 
				"			\n" + 
				"			cipherAES = Cipher.getInstance(\"AES/CBC/PKCS5Padding\");\n" + 
				"				\n" + 
				"			//initialize properties for SecureRandom\n" + 
				"			random = new SecureRandom();\n" + 
				"\n" + 
				"		} catch (NoSuchAlgorithmException e) {\n" + 
				"			s_logger.info(\"KeyPair couldn't be generated\\n\");\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (NoSuchPaddingException e) {\n" + 
				"			s_logger.info(\"Cipher couldn't be initialised\\n\");\n" + 
				"			e.printStackTrace();\n" + 
				"		} \n" + 
				"	}\n" + 
				"	\n" + 
				"	public PublicKey getPublicKey(){\n" + 
				"		return publicKey;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public HashMap<Node, SecretKey> getAesKeys() {\n" + 
				"		return aesKeys;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public void exchangeKey(SecurableNode node, SecurableNode sourceNode){\n" + 
				"		// create and save AESkey in TextFile Node.id + AESKey\n" + 
				"		KeyGenerator kgen = null;\n" + 
				"		try {\n" + 
				"			kgen = KeyGenerator.getInstance(\"AES\");\n" + 
				"		} catch (NoSuchAlgorithmException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		}\n" + 
				"		kgen.init(128);\n" + 
				"		SecretKey skey = kgen.generateKey();\n" + 
				"\n" + 
				"		//send encrypted key to source node\n" + 
				"		\n" + 
				"		sourceNode.receiveEncryptedKey(node, encryptKey(sourceNode.getPublicKey(), skey));\n" + 
				"\n" + 
				"		aesKeys.put(sourceNode, skey);\n" + 
				"	}\n" + 
				"	\n" + 
				"	private byte[] encryptKey(PublicKey publicKey, SecretKey skey) {\n" + 
				"	    try {\n" + 
				"		//init cipher\n" + 
				"		Cipher cipher;		\n" + 
				"		cipher = Cipher.getInstance(\"RSA/ECB/PKCS1Padding\");\n" + 
				"		cipher.init(Cipher.ENCRYPT_MODE, publicKey);\n" + 
				"\n" + 
				"	    //encrypt\n" + 
				"		return cipher.doFinal(skey.getEncoded());\n" + 
				"		\n" + 
				"		} catch (IllegalBlockSizeException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (BadPaddingException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (InvalidKeyException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		}\n" + 
				"		return null;\n" + 
				"	}\n" + 
				"\n" + 
				"	public SecretKey decryptKey(byte[] key){\n" + 
				"		try {\n" + 
				"		//init cipher\n" + 
				"		Cipher cipher;		\n" + 
				"		cipher = Cipher.getInstance(\"RSA/ECB/PKCS1Padding\");\n" + 
				"		cipher.init(Cipher.DECRYPT_MODE, privateKey);\n" + 
				"\n" + 
				"	    //decrypt and save key	\n" + 
				"		byte[]input =  cipher.doFinal(key);\n" + 
				"		\n" + 
				"		return  new SecretKeySpec(input, 0, input.length, \"AES\");\n" + 
				"		\n" + 
				"		} catch (InvalidKeyException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (IllegalBlockSizeException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (BadPaddingException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (NoSuchAlgorithmException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (NoSuchPaddingException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		}\n" + 
				"		return null;		\n" + 
				"	}\n" + 
				"	\n" + 
				"	public String encrypt(Object data, SecretKey skey) {\n" + 
				"		//convert object to byte array\n" + 
				"		byte[] input = SerializationUtils.serialize((Serializable) data);\n" + 
				"		\n" + 
				"		//initialize output buffer\n" + 
				"		int len = input.length*2;\n" + 
				"		if(len <MIN_OUT_BUFFER_SIZE){\n" + 
				"			len = MIN_OUT_BUFFER_SIZE;\n" + 
				"		}\n" + 
				"	    byte[] output = new byte[len];\n" + 
				"	       \n" + 
				"	    int total  = 0;\n" + 
				"		try{\n" + 
				"			random.nextBytes(IVBytes);\n" + 
				"			iv = new IvParameterSpec(IVBytes);\n" + 
				"			\n" + 
				"		    //Initializes the cipher with ENCRYPT_MODE, key and iv.\n" + 
				"		    cipherAES.init(Cipher.ENCRYPT_MODE, skey, iv);\n" + 
				"		    \n" + 
				"		    //Continues a multiple-part encryption/decryption operation for byte array.\n" + 
				"		    int updateBytes = cipherAES.update(input, 0, input.length, output, 0);\n" + 
				"\n" + 
				"		    //We must call doFinal at the end of encryption/decryption.\n" + 
				"		    int finalBytes = cipherAES.doFinal(input, 0, 0, output, updateBytes);\n" + 
				"		    \n" + 
				"		    total = updateBytes+finalBytes;\n" + 
				"		    \n" + 
				"		} catch (InvalidKeyException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (InvalidAlgorithmParameterException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (ShortBufferException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (IllegalBlockSizeException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (BadPaddingException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		}\n" + 
				"		return encodeB64(IVBytes) + \":\" + encodeB64(output,total);\n" + 
				"	}\n" + 
				"	public Object decrypt(String data, SecretKey skey) {\n" + 
				"		//retrieve cipher and iv \n" + 
				"		byte[] input = decodeB64(data.substring(data.indexOf(':') + 1, data.length()));\n" + 
				"		\n" + 
				"		IVBytes = decodeB64(data.substring(0, data.indexOf(':')));\n" + 
				"		iv = new IvParameterSpec(IVBytes);\n" + 
				"		\n" + 
				"		//initialize output buffer\n" + 
				"	    byte[] output = new byte[input.length];\n" + 
				"\n" + 
				"		try{\n" + 
				"		//Initializes the cipher with DECRYPT_MODE, key and iv.\n" + 
				"	    cipherAES.init(Cipher.DECRYPT_MODE, skey, iv);\n" + 
				"		\n" + 
				"	  //Continues a multiple-part encryption/decryption operation for byte array.\n" + 
				"	    int updateBytes = cipherAES.update(input, 0, input.length, output, 0);\n" + 
				"\n" + 
				"	    //We must call doFinal at the end of encryption/decryption.\n" + 
				"	    cipherAES.doFinal(input, 0, 0, output, updateBytes);\n" + 
				"\n" + 
				"		} catch (ShortBufferException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (IllegalBlockSizeException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (BadPaddingException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (InvalidKeyException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		} catch (InvalidAlgorithmParameterException e) {\n" + 
				"			e.printStackTrace();\n" + 
				"		}\n" + 
				"		return SerializationUtils.deserialize(output);\n" + 
				"	}\n" + 
				"	\n" + 
				"	private static String encodeB64(byte[] data){\n" + 
				"		return Base64.getEncoder().encodeToString(data);\n" + 
				"	}\n" + 
				"	\n" + 
				"	private static String encodeB64(byte[] data,int total){\n" + 
				"		byte[] sub = new byte[total];\n" + 
				"		System.arraycopy(data, 0, sub, 0, total);\n" + 
				"		return Base64.getEncoder().encodeToString(sub);\n" + 
				"	}\n" + 
				"	\n" + 
				"	private static byte[] decodeB64(String cipher){\n" + 
				"		return Base64.getDecoder().decode(cipher);\n" + 
				"	}\n"
				+ "}\n");
		IFolder packageFolder = project.getFolder(BwCPSConstants.JAVA_PROJECT_PACKAGE_PATH + projectName.replaceAll(" ", "").toLowerCase() + "/security/");
		prepare(packageFolder);
		createFile("SecurityManager.java", packageFolder, content.toString());
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
	public void prepare(IFolder folder) throws CoreException {
	    if (!folder.exists()) {
	        prepare((IFolder) folder.getParent());
	        folder.create(false, false, null);
	    }
	}
}
