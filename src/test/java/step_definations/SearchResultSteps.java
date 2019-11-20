package step_definations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.SearchResultPage;

/**
 * @author Amit
 *
 */
public class SearchResultSteps {

	public WebDriver driver;
	SearchResultPage searchResultPage;

	public SearchResultSteps() {
		driver = Hooks.driver;
		searchResultPage = new SearchResultPage(driver);
	}

	@When("^user clicks on price arrow button$")
	public void user_clicks_on_price_arrow_button() {
		searchResultPage.clickOnPriceArrow();
		Reporter.addStepLog("Price arrow clicked");
	}

	@Then("^user is able to see the cost of flight search results should be in decreasing order$")
	public void user_is_able_to_see_the_cost_of_flight_search_results_should_be_in_decreasing_order() {
		Assert.assertTrue(searchResultPage.isCostDisplayedInDecreasingOrder());
		Reporter.addStepLog("Cost displayed in decreasing order");
	}
}
