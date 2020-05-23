package de.fzi.bwcps.stream.analysis.report;

import java.util.Collection;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

public interface BWCPSAnalysisReport {
	
	public BWCPSAnalysisReportType getType();
	
	public String getMessage();
	
	public NamedElement getTarget();
	
	public Collection<BWCPSAnalysisReport> getDetailedReports();
}
