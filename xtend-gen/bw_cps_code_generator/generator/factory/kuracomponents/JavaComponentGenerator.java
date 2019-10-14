package bw_cps_code_generator.generator.factory.kuracomponents;

import bw_cps_code_generator.generator.GenerationUtil;
import bw_cps_code_generator.generator.factory.kuracomponents.NodeComponentsGenerator;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeLink;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;

/**
 * The JavaGenerator represents a concrete implementation of The ICodeGenerator and implements the
 * code-generator for the language Java.
 */
@SuppressWarnings("all")
public class JavaComponentGenerator {
  private String packagePrefix;
  
  public JavaComponentGenerator(final String packagePrefix) {
    this.packagePrefix = packagePrefix;
  }
  
  public HashMap<String, CharSequence> generateDTO(final NodeContainer container, final List<NodeLink> nodelinks) {
    String _entityUpperName = GenerationUtil.getEntityUpperName(container);
    EList<Node> _nodes = container.getNodes();
    return new NodeComponentsGenerator(_entityUpperName, _nodes, nodelinks, this.packagePrefix).generate();
  }
}
