package com.bio4j.exporter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.bio4j.exporter.ExporterCore;

public class ExporterCoreTest {

	@Test
	public void testSetFormatWithRegularFormat() {
		ExporterCore exporter = new ExporterCore();
		String testFormat = "graphml";
		try {
			exporter.setFormat(testFormat);
		} catch (Exception e) {
			fail("Exception thrown:" + e.toString());
		}
		assertEquals("setFormat handles regular formats", testFormat,
				exporter.getFormat());
	}

	@Test
	public void testSetFormatWithMixedCaseFormat() {
		ExporterCore exporter = new ExporterCore();
		String testFormat = "gRaPHml";
		try {
			exporter.setFormat(testFormat);
		} catch (Exception e) {
			fail("Exception thrown:" + e.toString());
		}
		assertEquals("setFormat handles mixed case formats",
				testFormat.toLowerCase(), exporter.getFormat());
	}

	// throws Exception when given an unknown format
	@Test(expected = Exception.class)
	public void testSetFormatWithInvalidFormat() throws Exception {
		ExporterCore exporter = new ExporterCore();
		String testFormat = "none";
		exporter.setFormat(testFormat);
	}

	// throws Exception when given an empty format
	@Test(expected = Exception.class)
	public void testSetFormatWithEmptyFormat() throws Exception {
		ExporterCore exporter = new ExporterCore();
		String testFormat = null;
		exporter.setFormat(testFormat);
	}

	@Test
	public void testSetLimitWithString() {
		ExporterCore exporter = new ExporterCore();
		String str = "42";
		int testLimit = 42;
		exporter.setLimit(str);
		assertEquals("setLimitString handles strings", testLimit,
				exporter.getLimit());
	}

	@Test
	public void testMaxTimeWithString() {
		ExporterCore exporter = new ExporterCore();
		String str = "42";
		int testMax = 42;
		exporter.setMaxTime(str);
		assertEquals("setMaxTime handles strings", testMax,
				exporter.getMaxTime());
	}

	@Test
	public void testSetStreamYes() {
		ExporterCore exporter = new ExporterCore();
		String str = "yes";
		try {
			exporter.setStream(str);
		} catch (Exception e) {
			fail("Exception thrown:" + e.toString());
		}
		assertEquals("setStream handles yes", true, exporter.isStream());
	}

	@Test
	public void testSetStreamNo() {
		ExporterCore exporter = new ExporterCore();
		String str = "no";
		try {
			exporter.setStream(str);
		} catch (Exception e) {
			fail("Exception thrown:" + e.toString());
		}
		assertEquals("setStream handles no", false, exporter.isStream());
	}

	@Test
	public void testSetStreamMixedCase() {
		ExporterCore exporter = new ExporterCore();
		String str = "nO";
		try {
			exporter.setStream(str);
		} catch (Exception e) {
			fail("Exception thrown:" + e.toString());
		}
		assertEquals("setStream handles no in mixed case", false,
				exporter.isStream());
	}

	// throws Exception when given an invalid response
	@Test(expected = Exception.class)
	public void testSetStreamWithInvalidResponse() throws Exception {
		ExporterCore exporter = new ExporterCore();
		String testFormat = "maybe";
		exporter.setStream(testFormat);
	}

	// throws Exception when given an empty response
	@Test(expected = Exception.class)
	public void testSetStreamWithEmptyResponse() throws Exception {
		ExporterCore exporter = new ExporterCore();
		String testFormat = null;
		exporter.setStream(testFormat);
	}
	
	@Test
	public void testSetQueryWithNull() {
		ExporterCore exporter = new ExporterCore();
		try {
			exporter.setQuery(null);
		} catch (Exception e) {
			fail("Exception thrown:" + e.toString());
		}
		assertEquals("setQuery handles null", null,
				exporter.getQuery());
	}
	@Test
	public void testSetQueryWithString() {
		ExporterCore exporter = new ExporterCore();
		String str = "g.v(2340)['com.bio4j.titan.model.go.nodes.TitanGoTerm.TitanGoTermType.name']";
		String expected = "g.v(2340)('com.bio4j.titan.model.go.nodes.TitanGoTerm.TitanGoTermType.name')";
		try {
			exporter.setQuery(str);
		} catch (Exception e) {
			fail("Exception thrown:" + e.toString());
		}
		assertEquals("setQuery handles a string", expected,
				exporter.getQuery());
	}
}
