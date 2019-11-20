package step_definations;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import library.ScreenShot;

/**
 * @author Amit
 *
 */
public class Hooks {

	public static WebDriver driver;
	library.TestConfig testConfig;
	String browser = null;
	public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Hooks.class);

	@Before
	public void openBrowser(Scenario scenario) throws MalformedURLException {
		browser = System.getProperty("browser");
		testConfig = new library.TestConfig(browser);
		driver = testConfig.getDriver();
	}

	@After
	/**
	 * Embed a screenshot
	 */
	public void embedScreenshot(Scenario scenario) {
		ScreenShot.takeScreenShot(driver);
		driver.quit();

	}
}
