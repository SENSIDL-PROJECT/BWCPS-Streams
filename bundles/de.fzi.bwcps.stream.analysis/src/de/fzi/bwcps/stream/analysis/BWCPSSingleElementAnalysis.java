package de.fzi.bwcps.stream.analysis;

import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

public interface BWCPSSingleElementAnalysis<T extends NamedElement>{
	
	public BWCPSAnalysisReport run(T element);
}