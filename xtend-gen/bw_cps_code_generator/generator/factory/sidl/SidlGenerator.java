package bw_cps_code_generator.generator.factory.sidl;

import bw_cps_code_generator.exception.MetamodelException;
import bw_cps_code_generator.generator.GenerationUtil;
import bw_cps_code_generator.generator.factory.ICodeGenerator;
import bw_cps_code_generator.generator.factory.sidl.SidlDTOGenerator;
import com.google.common.base.Objects;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * The SidlGenerator represents a concrete implementation of The ICodeGenerator and implements the
 * code-generator for the sidl file.
 * @author Sven Eckhardt
 */
@SuppressWarnings("all")
public class SidlGenerator implements ICodeGenerator {
  private String packagePrefix;
  
  public SidlGenerator(final String packagePrefix) {
    this.packagePrefix = packagePrefix;
  }
  
  /**
   * @see ICodeGenerator#generateDTO()
   */
  @Override
  public HashMap<String, CharSequence> generateDTO(final NamedElement element) {
    try {
      HashMap<String, CharSequence> _xblockexpression = null;
      {
        final NodeContainer container = ((NodeContainer) element);
        final Function1<Node, NodeType> _function = (Node node) -> {
          return node.getNodetype();
        };
        final List<NodeType> nodeTypes = ListExtensions.<Node, NodeType>map(container.getNodes(), _function).stream().distinct().collect(Collectors.<NodeType>toList());
        HashMap<String, CharSequence> _xifexpression = null;
        if (((!Objects.equal(nodeTypes, null)) && (!nodeTypes.isEmpty()))) {
          String _entityUpperName = GenerationUtil.getEntityUpperName(container);
          _xifexpression = new SidlDTOGenerator(_entityUpperName, nodeTypes, this.packagePrefix).generate();
        } else {
          String _entityUpperName_1 = GenerationUtil.getEntityUpperName(container);
          String _plus = ("NodeContainer " + _entityUpperName_1);
          String _plus_1 = (_plus + "doesn\'t have any node with a node type.");
          throw new MetamodelException(_plus_1);
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
