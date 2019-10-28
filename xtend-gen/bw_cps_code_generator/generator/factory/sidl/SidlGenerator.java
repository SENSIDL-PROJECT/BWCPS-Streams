package bw_cps_code_generator.generator.factory.sidl;

import bw_cps_code_generator.generator.BwCPSConstants;
import bw_cps_code_generator.generator.BwCPSExtentions;
import bw_cps_code_generator.generator.factory.sidl.SensIDLInvoker;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;
import de.fzi.bwcps.stream.bwcps_streams.entity.NodeType;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;
import de.fzi.sensidl.design.sensidl.SensorInterface;
import de.fzi.sensidl.design.sensidl.dataRepresentation.Data;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * The SidlGenerator represents a concrete implementation of The ICodeGenerator and implements the
 * code-generator for the sidl file.
 * @author Sven Eckhardt
 */
@SuppressWarnings("all")
public class SidlGenerator {
  private static final Logger logger = Logger.getLogger(SidlGenerator.class);
  
  public void generate(final NamedElement element) {
    final StreamRepository streamRepo = ((StreamRepository) element);
    final EList<NodeType> nodeTypes = streamRepo.getNodeTypes();
    final List<String> generatedData = new ArrayList<String>();
    if (((nodeTypes != null) && (!nodeTypes.isEmpty()))) {
      SidlGenerator.logger.info("Invoke SensIDL GenerationHandler");
      final Function1<NodeType, EList<Data>> _function = (NodeType n) -> {
        return n.getInput();
      };
      List<EList<Data>> _map = ListExtensions.<NodeType, EList<Data>>map(nodeTypes, _function);
      for (final EList<Data> d : _map) {
        {
          URI uri = EcoreUtil.getURI(d.get(0));
          boolean _equals = uri.fileExtension().equals(BwCPSExtentions.SENSIDL.getExtension());
          if (_equals) {
            uri = uri.trimFileExtension().appendFileExtension(BwCPSExtentions.SIDL.getExtension());
          }
          boolean _contains = generatedData.contains(uri.devicePath());
          boolean _not = (!_contains);
          if (_not) {
            IPath _location = ResourcesPlugin.getWorkspace().getRoot().getLocation();
            String _plus = (_location + "/");
            String _plus_1 = (_plus + BwCPSConstants.NODECONFIG_Project_NAME);
            String _plus_2 = (_plus_1 + 
              "/src/");
            EObject _eContainer = d.get(0).getDataSet().eContainer().eContainer();
            String _name = ((SensorInterface) _eContainer).getName();
            String _plus_3 = (_plus_2 + _name);
            SensIDLInvoker.generate(_plus_3, uri.devicePath());
            generatedData.add(uri.devicePath());
          }
        }
      }
      final Function1<NodeType, EList<Data>> _function_1 = (NodeType n) -> {
        return n.getOutput();
      };
      List<EList<Data>> _map_1 = ListExtensions.<NodeType, EList<Data>>map(nodeTypes, _function_1);
      for (final EList<Data> d_1 : _map_1) {
        {
          URI uri = EcoreUtil.getURI(d_1.get(0));
          boolean _equals = uri.fileExtension().equals(BwCPSExtentions.SENSIDL.getExtension());
          if (_equals) {
            uri = uri.trimFileExtension().appendFileExtension(BwCPSExtentions.SIDL.getExtension());
          }
          boolean _contains = generatedData.contains(uri.devicePath());
          boolean _not = (!_contains);
          if (_not) {
            IPath _location = ResourcesPlugin.getWorkspace().getRoot().getLocation();
            String _plus = (_location + "/");
            String _plus_1 = (_plus + BwCPSConstants.NODECONFIG_Project_NAME);
            String _plus_2 = (_plus_1 + 
              "/src/");
            EObject _eContainer = d_1.get(0).getDataSet().eContainer().eContainer();
            String _name = ((SensorInterface) _eContainer).getName();
            String _plus_3 = (_plus_2 + _name);
            SensIDLInvoker.generate(_plus_3, uri.devicePath());
            generatedData.add(uri.devicePath());
          }
        }
      }
    }
  }
}
