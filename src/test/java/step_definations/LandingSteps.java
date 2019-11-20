package step_definations;

import org.openqa.selenium.WebDriver;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageobjects.LandingPage;

/**
 * @author Amit
 *
 */
public class LandingSteps {

	public WebDriver driver;
	LandingPage landingPage;

	public LandingSteps() {
		driver = Hooks.driver;
		landingPage = new LandingPage(driver);
	}

	@Given("^user is on GoIbibo homepage$")
	public void user_is_on_GoIbibo_homepage() {
		landingPage.enterUrl();
		Reporter.addStepLog("GoIbibo homepage launched");
	}

	@When("^user selects source as \"([^\"]*)\"$")
	public void user_selects_source_as(String sourcePoint) {
		landingPage.enterSourcePoint(sourcePoint);
		Reporter.addStepLog("Source point selected");
	}

	@When("^user selects destination as \"([^\"]*)\"$")
	public void user_selects_destination_as(String destinationPoint) {
		landingPage.enterDestinatationPoint(destinationPoint);
		Reporter.addStepLog("Destination point selected");
	}

	@When("^user selects valid depart date$")
	public void user_selects_valid_depart_date() {
		landingPage.enterValidDepartureDate();
		Reporter.addStepLog("Departure date selected");
	}

	@When("^user clicks on flight search button$")
	public void user_clicks_on_flight_search_button() {
		landingPage.clickOnFlightSearchBtn();
		Reporter.addStepLog("Flight search button clicked");
	}
}
