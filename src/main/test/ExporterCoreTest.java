package main.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import main.java.ExporterCore;

import org.junit.Test;

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

	@Test(expected = Exception.class)
	public void testSetFormatWithInvalidFormat() throws Exception {
		ExporterCore exporter = new ExporterCore();
		String testFormat = "none";
		exporter.setFormat(testFormat);
	}

	@Test
	public void testSetLimitString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMaxTimeString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStreamString() {
		fail("Not yet implemented");
	}

}
