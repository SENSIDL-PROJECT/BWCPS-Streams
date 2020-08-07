package de.fzi.bwcps.stream.analysis;

import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

/**
 * A BWCPSAnalysis algorithm that can also be executed on a single model element.
 * Results of the analysis are reported as {@link BWCPSAnalysisReport}. 
 * 
 * @author Fabian Scheytt
 *
 * @param <T>
 */
public interface BWCPSSingleElementAnalysis<T extends NamedElement> extends BWCPSAnalysis<T>{
	
	public BWCPSAnalysisReport run(T element);
}
