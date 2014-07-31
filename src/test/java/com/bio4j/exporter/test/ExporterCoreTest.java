package com.bio4j.exporter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.bio4j.exporter.ExporterCore;
import com.bio4j.exporter.Relationship;

public class ExporterCoreTest {	

	// returns expected relationship
	@Test
	public void testReturnRelWithKnownRel() throws Exception {
		String expected = "com.bio4j.titan.model.go.relationships.TitanPositivelyRegulates.TitanPositivelyRegulatesType";
		String result = ExporterCore.returnRelString(Relationship.POSITIVELY_REGULATES);
		assertEquals(expected, result);
	}
	
	// returns expected relationship 
	@Test
	public void testReturnRelWithOtherKnownRel() throws Exception {
		String wrongExpectation = "com.bio4j.titan.model.go.relationships.TitanPositivelyRegulates.TitanPositivelyRegulatesType";
		String result = ExporterCore.returnRelString(Relationship.IS_A);
		assertFalse(wrongExpectation.equals(result));
	}
	
	// throws Exception when given an empty relationship
	@Test(expected = Exception.class)
	public void testReturnRelWithEmptyRel() throws Exception {
		ExporterCore.returnRelString(null);    
	}
		
}
