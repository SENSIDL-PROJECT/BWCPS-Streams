package de.fzi.bwcps.stream.analysis.report;

import java.util.Collection;
import java.util.Collections;

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

}
