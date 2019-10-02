package bw_cps_code_generator.generator.factory.java;

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider;
import bw_cps_code_generator.generator.GenerationUtil;
import bw_cps_code_generator.generator.factory.java.JavaEntityGenerator;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class JavaNodeTypeGenerator extends JavaEntityGenerator {
  private static final Logger logger = Logger.getLogger(JavaNodeTypeGenerator.class);
  
  private final List<NodeType> nodetypes;
  
  private String projectName;
  
  private final String packagePrefix;
  
  public JavaNodeTypeGenerator(final String projectName, final List<NodeType> nodetypes, final String packagePrefix) {
    this.projectName = projectName;
    this.nodetypes = nodetypes;
    this.packagePrefix = packagePrefix;
  }
  
  @Override
  public HashMap<String, CharSequence> generate() {
    HashMap<String, CharSequence> _xblockexpression = null;
    {
      JavaNodeTypeGenerator.logger.info("Generate node types.");
      final HashMap<String, CharSequence> filesToGenerate = new HashMap<String, CharSequence>();
      filesToGenerate.put("NodeType.java", this.generateInterfaceBody());
      JavaNodeTypeGenerator.logger.info(("File: NodeType.java was generated in " + 
        BwcpsOutputConfigurationProvider.BWCPS_GEN));
      for (final NodeType nodetype : this.nodetypes) {
        {
          filesToGenerate.put(this.addFileExtensionTo(GenerationUtil.getEntityUpperName(nodetype)), 
            this.generateClassBody(GenerationUtil.getEntityUpperName(nodetype), nodetype));
          String _addFileExtensionTo = this.addFileExtensionTo(GenerationUtil.getEntityUpperName(nodetype));
          String _plus = ("File: " + _addFileExtensionTo);
          String _plus_1 = (_plus + " was generated in ");
          String _plus_2 = (_plus_1 + 
            BwcpsOutputConfigurationProvider.BWCPS_GEN);
          JavaNodeTypeGenerator.logger.info(_plus_2);
        }
      }
      _xblockexpression = filesToGenerate;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateInterfaceBody() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(this.packagePrefix);
    String _lowerCase = this.projectName.toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append("* NodeType Iterface");
    _builder.newLine();
    _builder.append("*");
    _builder.newLine();
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public interface NodeType {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence generateClassBody(final String entityName, final NamedElement nodeType) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(this.packagePrefix);
    String _lowerCase = this.projectName.toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append("* NodeType: ");
    _builder.append(entityName);
    _builder.newLineIfNotEmpty();
    _builder.append("*");
    _builder.newLine();
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    CharSequence _generateImports = this.generateImports(nodeType);
    _builder.append(_generateImports);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(entityName);
    _builder.append(" implements NodeType {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateDataFields = this.generateDataFields(nodeType);
    _builder.append(_generateDataFields, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateConstructor = this.generateConstructor(nodeType, entityName);
    _builder.append(_generateConstructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateMethods = this.generateMethods(nodeType);
    _builder.append(_generateMethods, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateDataMethods = this.generateDataMethods(nodeType);
    _builder.append(_generateDataMethods, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence generateDataMethods(final NamedElement nodetype) {
    return null;
  }
  
  @Override
  public CharSequence generateConstructor(final NamedElement nodetype, final String className) {
    return null;
  }
  
  @Override
  public CharSequence generateDataFields(final NamedElement nodetype) {
    StringConcatenation _builder = new StringConcatenation();
    String _entityUpperName = GenerationUtil.getEntityUpperName(nodetype);
    _builder.append(_entityUpperName);
    _builder.append("InputDataSet input = new ");
    String _entityUpperName_1 = GenerationUtil.getEntityUpperName(nodetype);
    _builder.append(_entityUpperName_1);
    _builder.append("InputDataSet();");
    _builder.newLineIfNotEmpty();
    String _entityUpperName_2 = GenerationUtil.getEntityUpperName(nodetype);
    _builder.append(_entityUpperName_2);
    _builder.append("OutputDataSet output = new ");
    String _entityUpperName_3 = GenerationUtil.getEntityUpperName(nodetype);
    _builder.append(_entityUpperName_3);
    _builder.append("OutputDataSet();");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateImports(final NamedElement nodetype) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    String _lowerCase = GenerationUtil.getEntityLowerName(nodetype).toLowerCase();
    _builder.append(_lowerCase);
    _builder.append("inputdataset.");
    String _entityUpperName = GenerationUtil.getEntityUpperName(nodetype);
    _builder.append(_entityUpperName);
    _builder.append("InputDataSet;");
    _builder.newLineIfNotEmpty();
    _builder.append("import ");
    String _lowerCase_1 = GenerationUtil.getEntityLowerName(nodetype).toLowerCase();
    _builder.append(_lowerCase_1);
    _builder.append("outputdataset.");
    String _entityUpperName_1 = GenerationUtil.getEntityUpperName(nodetype);
    _builder.append(_entityUpperName_1);
    _builder.append("OutputDataSet;");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  @Override
  public CharSequence generateMethods(final NamedElement entity) {
    return null;
  }
}
