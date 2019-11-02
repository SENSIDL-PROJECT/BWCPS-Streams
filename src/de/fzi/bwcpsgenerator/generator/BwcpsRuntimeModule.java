package de.fzi.bwcpsgenerator.generator;

import org.eclipse.xtext.parser.IEncodingProvider;

import com.google.inject.AbstractModule;


public class BwcpsRuntimeModule extends AbstractModule {
	public Class<? extends IBwcpsCodeGenerator> bindISensidlCodeGenerator() {
        return BwcpsCodeGenerationExecutor.class;
    }
	

	@Override
	protected void configure() {
		bind(IEncodingProvider.class).to(IEncodingProvider.Runtime.class);
		
	}
}
