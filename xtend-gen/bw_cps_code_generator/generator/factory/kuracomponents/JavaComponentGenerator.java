package bw_cps_code_generator.generator.factory.kuracomponents;

import bw_cps_code_generator.generator.GenerationUtil;
import bw_cps_code_generator.generator.factory.ICodeGenerator;
import bw_cps_code_generator.generator.factory.kuracomponents.NodeComponentGenerator;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;

/**
 * The JavaGenerator represents a concrete implementation of The ICodeGenerator and implements the
 * code-generator for the language Java.
 */
@SuppressWarnings("all")
public class JavaComponentGenerator implements ICodeGenerator {
  private String packagePrefix;
  
  public JavaComponentGenerator(final String packagePrefix) {
    this.packagePrefix = packagePrefix;
  }
  
  @Override
  public HashMap<String, CharSequence> generateDTO(final NamedElement element) {
    HashMap<String, CharSequence> _xblockexpression = null;
    {
      final NodeContainer container = ((NodeContainer) element);
      String _entityUpperName = GenerationUtil.getEntityUpperName(container);
      EList<Node> _nodes = container.getNodes();
      _xblockexpression = new NodeComponentGenerator(_entityUpperName, _nodes, this.packagePrefix).generate();
    }
    return _xblockexpression;
  }
}
