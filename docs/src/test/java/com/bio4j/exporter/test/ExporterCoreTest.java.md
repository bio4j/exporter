
```java
package com.bio4j.exporter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.bio4j.exporter.ExporterCore;
import com.bio4j.exporter.Relationship;

/**
 * 
 * @author <a href="mailto:andre.garcia.nunes@gmail.com"> André Nunes </a>
 *
 */
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
	
	// returns correct path when null is given
	@Test
	public void testResolvePathWithNull() throws Exception {
		String defaultFileName = "bio4j.json";
		String result = ExporterCore.resolvePath(null, defaultFileName);
		assertEquals(defaultFileName, result);
	}
	
	// returns correct path when the path is given without file name
	@Test
	public void testResolvePathWithoutFileName() throws Exception {
		String defaultFileName = "bio4j.json";
		String expected = "/home/workspace/bio4j.json";		
		String result = ExporterCore.resolvePath("/home/workspace/", defaultFileName);
		String anotherResult = ExporterCore.resolvePath("/home/workspace", defaultFileName);
		assertEquals(expected, result);
		assertEquals(expected, anotherResult);
	}	
	
	// returns correct path when the full path is given
	@Test
	public void testResolvePathWithFileName() throws Exception {
		String defaultFileName = "bio4j.json";
		String expected = "/home/workspace/test.json";
		String result = ExporterCore.resolvePath("/home/workspace/test.json", defaultFileName);
		assertEquals(expected, result);
	}
}

```


------

### Index

+ src
  + main
    + resources
      + META-INF
        + services
    + java
      + com
        + bio4j
          + exporter
            + [Bio4jCommand.java][main/java/com/bio4j/exporter/Bio4jCommand.java]
            + [Bio4jGremlinPlugin.java][main/java/com/bio4j/exporter/Bio4jGremlinPlugin.java]
            + [ExporterCore.java][main/java/com/bio4j/exporter/ExporterCore.java]
            + [Relationship.java][main/java/com/bio4j/exporter/Relationship.java]
            + [GoTraversal.java][main/java/com/bio4j/exporter/GoTraversal.java]
  + test
    + java
      + com
        + bio4j
          + exporter
            + test
              + [AllTests.java][test/java/com/bio4j/exporter/test/AllTests.java]
              + [ExporterCoreTest.java][test/java/com/bio4j/exporter/test/ExporterCoreTest.java]

[main/java/com/bio4j/exporter/Bio4jCommand.java]: ../../../../../../main/java/com/bio4j/exporter/Bio4jCommand.java.md
[main/java/com/bio4j/exporter/Bio4jGremlinPlugin.java]: ../../../../../../main/java/com/bio4j/exporter/Bio4jGremlinPlugin.java.md
[main/java/com/bio4j/exporter/ExporterCore.java]: ../../../../../../main/java/com/bio4j/exporter/ExporterCore.java.md
[main/java/com/bio4j/exporter/Relationship.java]: ../../../../../../main/java/com/bio4j/exporter/Relationship.java.md
[main/java/com/bio4j/exporter/GoTraversal.java]: ../../../../../../main/java/com/bio4j/exporter/GoTraversal.java.md
[test/java/com/bio4j/exporter/test/AllTests.java]: AllTests.java.md
[test/java/com/bio4j/exporter/test/ExporterCoreTest.java]: ExporterCoreTest.java.md