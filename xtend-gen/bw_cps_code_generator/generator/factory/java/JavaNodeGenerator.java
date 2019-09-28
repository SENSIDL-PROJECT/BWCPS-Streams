package bw_cps_code_generator.generator.factory.java;

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider;
import bw_cps_code_generator.generator.GenerationUtil;
import bw_cps_code_generator.generator.factory.java.JavaEntityGenerator;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class JavaNodeGenerator extends JavaEntityGenerator {
  private static final Logger logger = Logger.getLogger(JavaNodeGenerator.class);
  
  private final List<Node> nodes;
  
  public JavaNodeGenerator(final List<Node> nodes) {
    this.nodes = nodes;
  }
  
  @Override
  public HashMap<String, CharSequence> generate() {
    HashMap<String, CharSequence> _xblockexpression = null;
    {
      JavaNodeGenerator.logger.info("Generate node.");
      final HashMap<String, CharSequence> filesToGenerate = new HashMap<String, CharSequence>();
      filesToGenerate.put("Node.java", this.generateInterfaceBody(this.nodes));
      JavaNodeGenerator.logger.info(("File: Node.java was generated in " + 
        BwcpsOutputConfigurationProvider.BWCPS_GEN));
      for (final Node node : this.nodes) {
        {
          filesToGenerate.put(this.addFileExtensionTo(GenerationUtil.getEntityUpperName(node)), 
            this.generateClassBody(GenerationUtil.getEntityUpperName(node), node));
          String _addFileExtensionTo = this.addFileExtensionTo(GenerationUtil.getEntityUpperName(node));
          String _plus = ("File: " + _addFileExtensionTo);
          String _plus_1 = (_plus + " was generated in ");
          String _plus_2 = (_plus_1 + 
            BwcpsOutputConfigurationProvider.BWCPS_GEN);
          JavaNodeGenerator.logger.info(_plus_2);
        }
      }
      _xblockexpression = filesToGenerate;
    }
    return _xblockexpression;
  }
  
  public CharSequence generateInterfaceBody(final List nodes) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package nodes;");
    _builder.newLine();
    _builder.append("import nodes.Node;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append("* NodeLink Interface");
    _builder.newLine();
    _builder.append("*");
    _builder.newLine();
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    _builder.append("public interface Node {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Node getNodetype();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public Node getOperation();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence generateClassBody(final String entityName, final NamedElement stream) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package nodes;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import nodes.Node;");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append("* NodeLink: ");
    _builder.append(entityName);
    _builder.newLineIfNotEmpty();
    _builder.append("*");
    _builder.newLine();
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(entityName);
    _builder.append(" implements Node {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static final long serialVersionUID = 1L;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateDataFields = this.generateDataFields(stream);
    _builder.append(_generateDataFields, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateConstructor = this.generateConstructor(stream, entityName);
    _builder.append(_generateConstructor, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateMethods = this.generateMethods(stream);
    _builder.append(_generateMethods, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generateDataMethods = this.generateDataMethods(stream);
    _builder.append(_generateDataMethods, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence generateDataMethods(final NamedElement entity) {
    return null;
  }
  
  @Override
  public CharSequence generateConstructor(final NamedElement entity, final String className) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("public ");
    _builder.append(className);
    _builder.append("(NodeType nodeType, Operation operational) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.nodeType = nodeType;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("this.operational = operational;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Generates Methods
   */
  public Object generateMethods(final StreamRepository repo) {
    return null;
  }
  
  @Override
  public CharSequence generateDataFields(final NamedElement entity) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private Node source;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("private Node target;");
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence generateMethods(final NamedElement entity) {
    return null;
  }
}
