package de.fzi.bwcps.stream.analysis.report;

import java.util.Collection;

import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

/**
 * Interface for structured reporting of any BWCPS analysis results.
 * 
 * @author Fabian Scheytt
 *
 */
public interface BWCPSAnalysisReport {
	
	/**
	 * Returns the type of the analysis report
	 * @return type
	 * 
	 * @see {@link BWCPSAnalysisReportType.INFO}
	 * @see	{@link BWCPSAnalysisReportType.WARNING}
	 * @see {@link BWCPSAnalysisReportType.ERROR}
	 */
	public BWCPSAnalysisReportType getType();
	
	/**
	 * Returns the message of the analysis report attached to the target
	 * @return message
	 */
	public String getMessage();
	
	/**
	 * Returns the target element this concrete analysis report
	 * is directed at.
	 * @return BWCPS target element
	 */
	public NamedElement getTarget();
	
	/**
	 * Returns a list of more detailed reports concerning the issues of this report or
	 * reports referencing additional target elements for this issue ,if any exist.
	 * @return Additional analysis reports
	 */
	public Collection<BWCPSAnalysisReport> getDetailedReports();
}
