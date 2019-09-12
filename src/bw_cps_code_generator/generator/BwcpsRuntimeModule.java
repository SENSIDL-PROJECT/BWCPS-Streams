package bw_cps_code_generator.generator;

import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.parser.IEncodingProvider;

import com.google.inject.AbstractModule;

import bw_cps_code_generator.generator.BwcpsCodeGenerationExecutor;
import bw_cps_code_generator.generator.BwcpsOutputConfigurationProvider;
import bw_cps_code_generator.generator.IBwcpsCodeGenerator;


public class BwcpsRuntimeModule extends AbstractModule {
	public Class<? extends IBwcpsCodeGenerator> bindISensidlCodeGenerator() {
        return BwcpsCodeGenerationExecutor.class;
    }
	

	@Override
	protected void configure() {
		bind(IEncodingProvider.class).to(IEncodingProvider.Runtime.class);
		
	}
}
