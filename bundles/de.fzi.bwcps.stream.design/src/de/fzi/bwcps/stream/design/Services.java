package de.fzi.bwcps.stream.design;

import org.eclipse.emf.ecore.EObject;

import de.fzi.bwcps.stream.analysis.BWCPSAnalyzer;
import de.fzi.bwcps.stream.analysis.BWCPSTimelinessAnalyzer;
import de.fzi.bwcps.stream.bwcps_streams.entity.Node;
import de.fzi.bwcps.stream.bwcps_streams.entity.Stream;

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
    		return new BWCPSAnalyzer().analyzeNode((Node)self);
    	return null;
    }
    
    public String analyzeStream(EObject self) {
    	if (self instanceof Stream)
    		return new BWCPSTimelinessAnalyzer().run((Stream) self).getMessage();
    	return null;
    }
}
