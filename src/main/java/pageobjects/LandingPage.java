package pageobjects;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import library.FileUtil;

/**
 * @author Amit
 *
 */
public class LandingPage {

	public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LandingPage.class);

	Map<String, String> envProperies;
	String env = null;

	protected final WebDriver driver;
	protected final WebDriverWait wait;

	@FindBy(xpath = "//*[@id='gosuggest_inputSrc']")
	private WebElement inputSource;

	@FindBy(xpath = "//*[@id='gosuggest_inputSrc']/..//ul")
	private WebElement srcAutoSuggestList;

	@FindBy(xpath = "//*[@id='gosuggest_inputDest']")
	private WebElement inputDestination;

	@FindBy(xpath = "//*[@id='gosuggest_inputDest']/..//ul")
	private WebElement destAutoSuggestList;

	@FindBy(xpath = "//input[@placeholder='Departure']")
	private WebElement departureDateIcon;

	@FindBy(xpath = "//div[@class='DayPicker-Month']//div[@aria-selected='true']")
	private WebElement todayDepartureDate;

	@FindBy(xpath = "//button[@id='gi_search_btn']")
	private WebElement searchBtn;

	public LandingPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void enterUrl() {
		env = System.getProperty("env");
		if (env==null) {
			Assert.fail("Please provide the DEV/UAT env. Refer the README.md");
		}
		envProperies = FileUtil.getConfigProperties(env);
		driver.get(envProperies.get("url"));
		log.info("Url entered: " + envProperies.get("url"));
	}

	public void enterSourcePoint(String sourcePoint) {
		wait.until(ExpectedConditions.visibilityOf(inputSource));
		inputSource.sendKeys(sourcePoint);
		wait.until(ExpectedConditions.visibilityOf(srcAutoSuggestList));
		Actions actions = new Actions(driver);
		actions.contextClick(inputSource).sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.RETURN).build().perform();
		log.info("Source point entered: " + inputSource.getAttribute("value"));
		Reporter.addStepLog("Source point entered: " + inputSource.getAttribute("value"));
	}

	public void enterDestinatationPoint(String sourcePoint) {
		wait.until(ExpectedConditions.visibilityOf(inputDestination));
		inputDestination.sendKeys(sourcePoint);
		wait.until(ExpectedConditions.visibilityOf(destAutoSuggestList));
		Actions actions = new Actions(driver);
		actions.contextClick(inputDestination).sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.RETURN).build().perform();
		log.info("Destination point entered: " + inputDestination.getAttribute("value"));
		Reporter.addStepLog("Destination point entered: " + inputDestination.getAttribute("value"));
	}

	public void enterValidDepartureDate() {
		departureDateIcon.click();
		wait.until(ExpectedConditions.visibilityOf(todayDepartureDate));
		todayDepartureDate.click();
		log.info("Departure date selected: " + departureDateIcon.getAttribute("value"));
		Reporter.addStepLog("Departure date selected: " + departureDateIcon.getAttribute("value"));
	}

	public void clickOnFlightSearchBtn() {
		searchBtn.click();
		log.info("Flight search button clicked");

	}

}
