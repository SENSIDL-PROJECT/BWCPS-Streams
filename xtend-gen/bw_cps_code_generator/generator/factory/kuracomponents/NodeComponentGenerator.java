package bw_cps_code_generator.generator.factory.kuracomponents;

import bw_cps_code_generator.generator.BwCPSConstants;
import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider;
import bw_cps_code_generator.generator.GenerationUtil;
import bw_cps_code_generator.generator.factory.IDTOGenerator;
import bw_cps_code_generator.generator.factory.kuracomponents.MethodGenerator;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class NodeComponentGenerator implements IDTOGenerator {
  private static final Logger logger = Logger.getLogger(NodeComponentGenerator.class);
  
  private final List<Node> nodes;
  
  private final String projectName;
  
  private int count = 0;
  
  private final String packagePrefix;
  
  public NodeComponentGenerator(final String projectName, final List<Node> nodes, final String newPackagePrefix) {
    this.projectName = projectName;
    this.nodes = nodes;
    this.packagePrefix = newPackagePrefix;
  }
  
  @Override
  public HashMap<String, CharSequence> generate() {
    HashMap<String, CharSequence> _xblockexpression = null;
    {
      NodeComponentGenerator.logger.info("Generate node.");
      final HashMap<String, CharSequence> filesToGenerate = new HashMap<String, CharSequence>();
      for (final Node node : this.nodes) {
        {
          filesToGenerate.put(this.addFileExtensionTo(GenerationUtil.getEntityUpperName(node)), 
            this.generateClassBody(GenerationUtil.getEntityUpperName(node), node));
          String _addFileExtensionTo = this.addFileExtensionTo(GenerationUtil.getEntityUpperName(node));
          String _plus = ("File: " + _addFileExtensionTo);
          String _plus_1 = (_plus + " was generated in ");
          String _plus_2 = (_plus_1 + 
            BwcpsOutputConfigurationProvider.BWCPS_GEN);
          NodeComponentGenerator.logger.info(_plus_2);
        }
      }
      _xblockexpression = filesToGenerate;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateClassBody(final String entityName, final Node node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(this.packagePrefix);
    String _lowerCase = this.projectName.toLowerCase();
    _builder.append(_lowerCase);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("import org.osgi.service.component.ComponentContext;");
    _builder.newLine();
    _builder.append("import org.osgi.service.component.annotations.Activate;");
    _builder.newLine();
    _builder.append("import org.osgi.service.component.annotations.Component;");
    _builder.newLine();
    _builder.append("import org.osgi.service.component.annotations.Deactivate;");
    _builder.newLine();
    _builder.append("import org.slf4j.Logger;");
    _builder.newLine();
    _builder.append("import org.slf4j.LoggerFactory;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append("* Node: ");
    _builder.append(entityName);
    _builder.newLineIfNotEmpty();
    _builder.append("*");
    _builder.newLine();
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Component\t");
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(entityName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateDataFields = this.generateDataFields(entityName, node);
    _builder.append(_generateDataFields, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateMethods = this.generateMethods(node);
    _builder.append(_generateMethods, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Generates DataFields
   */
  public CharSequence generateDataFields(final String entityName, final Node node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private static final Logger s_logger = LoggerFactory.getLogger(");
    _builder.append(entityName);
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("private static final String APP_ID = \"");
    _builder.append(this.projectName);
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("private static final long serialVersionUID = 1L;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("private static final NodeType nodeType = new ");
    String _entityUpperName = GenerationUtil.getEntityUpperName(node.getNodetype());
    _builder.append(_entityUpperName);
    _builder.append("();\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * Generates Methods
   */
  public CharSequence generateMethods(final Node node) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("@Activate");
    _builder.newLine();
    _builder.append("protected void activate(ComponentContext componentContext) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("s_logger.info(\"Bundle \" + APP_ID + \" has started!\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("s_logger.debug(APP_ID + \": This is a debug message.\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//TODO This is an auto-generated method ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Deactivate");
    _builder.newLine();
    _builder.append("protected void deactivate(ComponentContext componentContext) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("s_logger.info(\"Bundle \" + APP_ID + \" has stopped!\");");
    _builder.newLine();
    _builder.newLine();
    _builder.append("//TODO This is an auto-generated method ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    CharSequence _generateMethods = MethodGenerator.generateMethods(node.getOperational());
    _builder.append(_generateMethods);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public String addFileExtensionTo(final String className) {
    return (className + BwCPSConstants.JAVA_EXTENSION);
  }
  
  public String toTypeName(final String name) {
    String _switchResult = null;
    if (name != null) {
      switch (name) {
        case "INT8":
          _switchResult = "byte";
          break;
        case "UINT8":
          _switchResult = "byte";
          break;
        case "INT16":
          _switchResult = "short";
          break;
        case "UINT16":
          _switchResult = "short";
          break;
        case "INT32":
          _switchResult = "int";
          break;
        case "UINT32":
          _switchResult = "int";
          break;
        case "INT64":
          _switchResult = "long";
          break;
        case "UINT64":
          _switchResult = "long";
          break;
        case "FLOAT":
          _switchResult = "float";
          break;
        case "DOUBLE":
          _switchResult = "double";
          break;
        case "BOOLEAN":
          _switchResult = "boolean";
          break;
        case "STRING":
          _switchResult = "String";
          break;
        default:
          _switchResult = "";
          break;
      }
    } else {
      _switchResult = "";
    }
    return _switchResult;
  }
}
