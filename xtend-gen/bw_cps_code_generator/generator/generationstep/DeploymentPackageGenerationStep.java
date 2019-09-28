package bw_cps_code_generator.generator.generationstep;

import bw_cps_code_generator.generator.BwCPSConstants;
import bw_cps_code_generator.generator.BwCPSConstants.GenerationLanguage;
import bw_cps_code_generator.generator.GenerationUtil;
import bw_cps_code_generator.generator.IExecuter;
import bw_cps_code_generator.generator.elementfilter.ElementFilter;
import bw_cps_code_generator.generator.generationstep.FileGenerationStep;
import bw_cps_code_generator.generator.generationstep.GenerationStep;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

@SuppressWarnings("all")
public class DeploymentPackageGenerationStep extends GenerationStep {
  private static final String PATH_SEPERATOR = "/";
  
  private final String projectName;
  
  private final IFileSystemAccess fsa;
  
  private StreamRepository streamRepo;
  
  /**
   * The constructor calls the needed data filtered by a
   * concrete element-filter.
   * @param filter - represents a base filter which can be substituted by a specific
   * 				   subclass that filters a particular set of elements.
   */
  public DeploymentPackageGenerationStep(final ElementFilter filter, final IFileSystemAccess newFsa) {
    this.streamRepo = filter.<StreamRepository>filterData();
    this.projectName = GenerationUtil.getEntityUpperName(this.streamRepo);
    this.fsa = newFsa;
  }
  
  @Override
  public void startGenerationTask() {
  }
  
  private void resetGenerationSettings(final String projectPath, final String path) {
    GenerationStep.javaPackagePrefix = BwCPSConstants.JAVA_PROJECT_PACKAGE_PREFIX;
    FileGenerationStep.filePath = this.getFilePathOf(path);
    ((JavaIoFileSystemAccess) this.fsa).setOutputPath(projectPath);
  }
  
  private String getFilePathOf(final String path) {
    String _xblockexpression = null;
    {
      final StringBuilder builder = new StringBuilder(path);
      builder.append(DeploymentPackageGenerationStep.PATH_SEPERATOR);
      builder.append(this.projectName);
      builder.append(DeploymentPackageGenerationStep.PATH_SEPERATOR);
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }
  
  /**
   * Initializes a HashMap that maps each {@link GenerationLanguage} to a
   * {@link IExecuter} object.
   * @return the HashMap {@link GenerationLanguage} to {@link IExecuter}
   */
  private Object getResourcesToGenerateMapping() {
    return null;
  }
}
