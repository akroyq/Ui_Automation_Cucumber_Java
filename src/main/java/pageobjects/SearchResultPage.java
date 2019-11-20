package pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.cucumber.listener.Reporter;

/**
 * @author Amit
 *
 */
public class SearchResultPage {

	public static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SearchResultPage.class);

	protected final WebDriver driver;
	protected final WebDriverWait wait;

	@FindBy(xpath = "//*[@data-cy='finalPrice']")
	private List<WebElement> searchResultPriceList;

	@FindBy(xpath = "//button[text()='Modify search and try again']| //*[contains(text(),'Sorry')]")
	private List<WebElement> sorryPopup;

	@FindBy(xpath = "//*[@class='fl width100 flexCol']")
	private List<WebElement> noOfFlights;

	@FindBy(xpath = "//*[@class='fb ico11  hpyBlueLt ']")
	private WebElement priceArrow;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}

	public void clickOnPriceArrow() {
		if (sorryPopup.isEmpty()) {
			wait.until(ExpectedConditions.visibilityOf(noOfFlights.get(0)));
			log.info(noOfFlights.size() + " " + "flights details displayed");
			Reporter.addStepLog(noOfFlights.size() + " " + "flights details displayed");
		} else {
			Assert.fail("OOps no flights founds. Please provide the valid inputs");
		}
		priceArrow.click();
		log.info("Price arrow clicked");
	}

	public boolean isCostDisplayedInDecreasingOrder() {
		boolean flag = false;
		ArrayList<Integer> expectedPriceList = new ArrayList<Integer>();
		log.info("Flights cost are: ");
		for (int i = 0; i < searchResultPriceList.size(); i++) {
			JavascriptExecutor jsx = ((JavascriptExecutor) driver);
			jsx.executeScript("arguments[0].scrollIntoView(true);", searchResultPriceList.get(i));
			log.info(searchResultPriceList.get(i).getText());
			Reporter.addStepLog(searchResultPriceList.get(i).getText());
			expectedPriceList.add(i, Integer.parseInt(searchResultPriceList.get(i).getText().replace(",", "")));
		}
		ArrayList<Integer> actualPriceList = expectedPriceList;
		Collections.sort(expectedPriceList, Collections.reverseOrder());
		if (Arrays.equals(actualPriceList.toArray(), expectedPriceList.toArray())) {
			flag = true;
			log.info("Cost displayed in decreasing order");

		} else {
			flag = false;
			log.info("Cost not displayed in decreasing order");
			Reporter.addStepLog("Cost not displayed in decreasing order");
		}
		return flag;
	}
}
