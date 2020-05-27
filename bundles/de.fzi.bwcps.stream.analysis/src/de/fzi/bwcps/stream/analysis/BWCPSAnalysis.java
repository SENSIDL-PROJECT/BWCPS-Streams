package de.fzi.bwcps.stream.analysis;

import java.util.Collection;
import java.util.List;

import de.fzi.bwcps.stream.analysis.report.BWCPSAnalysisReport;
import de.fzi.bwcps.stream.bwcps_streams.commons.NamedElement;

public interface BWCPSAnalysis<T extends NamedElement> {

	public List<BWCPSAnalysisReport> run(Collection<T> elements);
}
