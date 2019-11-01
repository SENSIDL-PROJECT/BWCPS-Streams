package bw_cps_code_generator.generator.factory.java;

import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider;
import bw_cps_code_generator.generator.GenerationUtil;
import bw_cps_code_generator.generator.factory.java.JavaEntityGenerator;
import com.google.common.base.Objects;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.sensidl.design.sensidl.SensorInterface;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
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
  
  public CharSequence generateClassBody(final String entityName, final NodeType nodeType) {
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
    _builder.append("public abstract class ");
    _builder.append(entityName);
    _builder.append(" {");
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
    Object _generateDataMethods = this.generateDataMethods(nodeType);
    _builder.append(_generateDataMethods, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public Object generateDataMethods(final NodeType nodetype) {
    return null;
  }
  
  public CharSequence generateDataFields(final NodeType nodetype) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected ");
    String _name = nodetype.getInput().get(0).getDataSet().getName();
    _builder.append(_name);
    _builder.append(" input = new ");
    String _name_1 = nodetype.getInput().get(0).getDataSet().getName();
    _builder.append(_name_1);
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("protected ");
    String _name_2 = nodetype.getOutput().get(0).getDataSet().getName();
    _builder.append(_name_2);
    _builder.append(" output = new ");
    String _name_3 = nodetype.getOutput().get(0).getDataSet().getName();
    _builder.append(_name_3);
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateImports(final NodeType nodetype) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    EObject _eContainer = nodetype.getInput().get(0).getDataSet().eContainer().eContainer();
    String _name = ((SensorInterface) _eContainer).getName();
    _builder.append(_name);
    _builder.append(".");
    String _name_1 = nodetype.getInput().get(0).getDataSet().getName();
    _builder.append(_name_1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      String _name_2 = nodetype.getInput().get(0).getDataSet().getName();
      String _name_3 = nodetype.getOutput().get(0).getDataSet().getName();
      boolean _notEquals = (!Objects.equal(_name_2, _name_3));
      if (_notEquals) {
        _builder.append("import ");
        EObject _eContainer_1 = nodetype.getOutput().get(0).getDataSet().eContainer().eContainer();
        String _name_4 = ((SensorInterface) _eContainer_1).getName();
        _builder.append(_name_4);
        _builder.append(".");
        String _name_5 = nodetype.getOutput().get(0).getDataSet().getName();
        _builder.append(_name_5);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
