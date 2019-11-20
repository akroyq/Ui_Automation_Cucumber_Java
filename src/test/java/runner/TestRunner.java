package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author Amit
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = { "step_definations" }, plugin = { "html:target/cucumber-html-report",
		"json:target/cucumber.json", "pretty:target/cucumber-pretty.text", "junit:target/cucumber-results.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:extentreport/report.html", "library.FeatureFileLogger:custom-formatter-output.txt"}, tags = { "@flightsearch" }, dryRun = false)
public class TestRunner {

	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("./src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("User", System.getProperty("user.name"));
		Reporter.setSystemInfo("Os", System.getProperty("os.name"));
		Reporter.setSystemInfo("Enveroment", System.getProperty("env"));
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}
