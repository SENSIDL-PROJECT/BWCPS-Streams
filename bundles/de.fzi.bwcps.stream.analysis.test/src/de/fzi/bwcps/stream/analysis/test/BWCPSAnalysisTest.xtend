package de.fzi.bwcps.stream.analysis.test

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsInstanceOf.instanceOf
import java.io.File
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.jupiter.api.BeforeAll
import de.fzi.bwcps.stream.bwcps_streams.entity.StreamRepository
import de.fzi.bwcps.stream.bwcps_streams.entity.entityPackage
import de.fzi.bwcps.stream.bwcps_streams.entity.entityFactory

abstract class BWCPSAnalysisTest {
	@BeforeAll def static void registerMetamodels() {
		entityPackage.eINSTANCE.getClass()
	}

	/** 
	 * Loads a BWCPS stream model from an relative path pointing to an .entity resource 
	 * @return
	 */
	def protected StreamRepository loadStreamModel(String relativePath) {
		var ResourceSet res = new ResourceSetImpl()
		res.getResource(URI.createFileURI(new File(relativePath).getAbsolutePath()), true)
		assertThat(res.getResources().get(0).getContents().get(0), instanceOf(StreamRepository))
		return (res.getResources().get(0).getContents().get(0) as StreamRepository)
	}
	
	/**
	 * Creates a new StreamRepository contained in a resource
	 */
	def protected StreamRepository createStreamModel() {
		var resSet = new ResourceSetImpl()
		var res = resSet.createResource(URI.createFileURI("./tmpResource.entity"))
		res.contents.add(entityFactory.eINSTANCE.createStreamRepository)
		res.contents.get(0) as StreamRepository
	}
}
