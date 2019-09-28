package bw_cps_code_generator.generator.elementfilter;

import bw_cps_code_generator.generator.elementfilter.ElementFilter;
import com.google.common.collect.Iterables;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeContainer;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class NodeContainerFilter extends ElementFilter {
  /**
   * Implements the abstract method of the base-class and filters the SensorInterface-elements.
   * @see ElementFilter#filterData()
   */
  @Override
  public List<NodeContainer> filterData() {
    return IterableExtensions.<NodeContainer>toList(Iterables.<NodeContainer>filter(ElementFilter.input.getContents(), NodeContainer.class));
  }
}
