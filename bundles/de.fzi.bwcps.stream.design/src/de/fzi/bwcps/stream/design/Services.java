package de.fzi.bwcps.stream.design;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.bwcps.stream.analysis.BWCPSBandwithAnalyzer;
import de.fzi.bwcps.stream.analysis.BWCPSTimelinessAnalyzer;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.Stream;
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository;

/**
 * The services class used by VSM.
 */
public class Services {
    
    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }
    
    public String analyzeNode(EObject self) {
    	if (self instanceof Node)
    		return new BWCPSBandwithAnalyzer().run((Node)self).getMessage();
    	return null;
    }
    
    public String analyzeStream(EObject self) {
    	if (self instanceof Stream)
    		return new BWCPSTimelinessAnalyzer().run((Stream) self).getMessage();
    	return null;
    }
    
    public StreamRepository getRoot(EObject self) {
    	return (StreamRepository) EcoreUtil.getRootContainer(self, true);
    }
}
