package de.fzi.bwcps.stream.analysis.report;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

public class BWCPSAnalysisReportImpl implements BWCPSAnalysisReport {
	
	private BWCPSAnalysisReportType type;
	
	private String message;
	
	private NamedElement target;
	
	private Collection<BWCPSAnalysisReport> furtherReports;
	
	public BWCPSAnalysisReportImpl() {
		this.furtherReports = Collections.emptyList();
	}
	
	public BWCPSAnalysisReportImpl(BWCPSAnalysisReportType type, String message, 
			NamedElement target, Collection<BWCPSAnalysisReport> furtherReports) {
		this.type = type;
		this.message = message;
		this.target = target;
		this.furtherReports = furtherReports;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public NamedElement getTarget() {
		return target;
	}

	@Override
	public BWCPSAnalysisReportType getType() {
		return this.type;
	}

	@Override
	public Collection<BWCPSAnalysisReport> getDetailedReports() {
		return this.furtherReports;
	}
	
	public BWCPSAnalysisReportImpl type(BWCPSAnalysisReportType type) {
		this.type = type;
		return this;
	}
	
	public BWCPSAnalysisReportImpl message(String message) {
		this.message = message;
		return this;
	}
	
	public BWCPSAnalysisReportImpl target(NamedElement target) {
		this.target = target;
		return this;
	}
	
	public BWCPSAnalysisReportImpl detailedReports(Collection<BWCPSAnalysisReport> details) {
		this.furtherReports = details;
		return this;
	}
	
	private void reportToStringRecursive(BWCPSAnalysisReport node, StringBuilder result, int depth) {
		if(node == null)
	        return;
	    // add this report to result with indentation
	    result.append(System.lineSeparator());
	    for(int i=0; i<depth; i++)
	        result.append("  ");
	    result.append(node.getType() + " " + node.getTarget() + ": " + node.getMessage());
	    
	    if (node.getDetailedReports() != null)
		    for (BWCPSAnalysisReport sucessor : node.getDetailedReports()) {
		    	reportToStringRecursive(sucessor, result, depth + 1);
		    }
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		reportToStringRecursive(this, builder, 0);
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		BWCPSAnalysisReport report = (BWCPSAnalysisReport) obj;
		return type == report.getType() &&
				Objects.equals(message, report.getMessage()) &&
				Objects.equals(target, report.getTarget()) &&
				Objects.equals(furtherReports, report.getDetailedReports());
	}
}
