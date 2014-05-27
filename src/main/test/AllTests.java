package main.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Bio4jExporterTest.class, ExporterCoreTest.class })
public class AllTests {

}