package de.fzi.bwcps.stream.analysis;

import java.util.Collection;
import java.util.List;

import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

/**
 * BWCPSAnalysis represents an edge analysis algorithm that can be executed on a number of 
 * {@link NamedElement}s. Results of the analysis are reported as {@link BWCPSAnalysisReport}. 
 * 
 * @author Fabian Scheytt
 *
 * @param <T>
 */
public interface BWCPSAnalysis<T extends NamedElement> {

	public List<BWCPSAnalysisReport> run(Collection<T> elements);
}
