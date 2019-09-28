package bw_cps_code_generator.generator.factory.java;

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider;
import bw_cps_code_generator.generator.GenerationUtil;
import bw_cps_code_generator.generator.factory.java.JavaDataRepresentaionGenerator;
import bw_cps_code_generator.generator.factory.java.JavaEntityGenerator;
import dataRepresentation.Data;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;
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
      final Class<Data> c = Data.class;
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
  public CharSequence generateClassBody(final String entityName, final NamedElement stream) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package nodes;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import nodes.NodeType;");
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
    _builder.append("\t");
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(entityName);
    _builder.append(" implements Stream {");
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
    _builder.append("(Node source, Node target) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.source = source;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("this.target = target;");
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
    CharSequence _generateDataFields = new JavaDataRepresentaionGenerator().generateDataFields(entity);
    _builder.append(_generateDataFields);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
  
  @Override
  public CharSequence generateMethods(final NamedElement entity) {
    return null;
  }
}
