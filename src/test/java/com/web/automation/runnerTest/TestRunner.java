package com.web.automation.runnerTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".//featureFiles/Assignment.feature", 
        monochrome = true, 
        dryRun =false,
        glue = {"com.web.automation.stepDefinition"},
        plugin={"pretty", "junit:target/JunitReports/report.xml", 
        		 "json:target/JSONReports/report.json", 
        		 "html:target/HTMLReports/report.html"},
        tags="@Assignment"
)
public class TestRunner {
	
	@BeforeClass
	public static void setReportConfiguration()
	{
		ExtentProperties  prop = ExtentProperties.INSTANCE;
		prop.setReportPath("./reports/report.html");
	}
	@AfterClass
	public static void setConfiguration()
	{
		Reporter.loadXMLConfig("./configFile/extent-config.xml");
	}
}

