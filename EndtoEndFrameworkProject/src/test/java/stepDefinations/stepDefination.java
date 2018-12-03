package stepDefinations;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageOjects.LandingPage;
import pageOjects.LoginPage;
import pageOjects.portalHomePage;
import resources.base;

public class stepDefination extends base {
	@Given("^Initialize browser with chrome browser$")
	public void initialize_browser_with_chrome_browser() throws IOException  {
	   
		driver=iniilizeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) {
	   
		driver.get(arg1);
	}

	@Given("^Click on log link in home page to land on secure log in page$")
	public void click_on_log_link_in_home_page_to_land_on_secure_log_in_page()  {
	   
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and Logs In$")
	public void user_enters_and_and_Logs_In(String arg1, String arg2)  {
	    
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(arg1);
		lp.getPassword().sendKeys(arg2);
		
		lp.submitLogin().click();
	}

	@Then("^Verify that user is successfully Logged In$")
	public void verify_that_user_is_successfully_Logged_In()  {
	    
	   portalHomePage p = new portalHomePage(driver);
	   Assert.assertTrue(p.getSearchBox().isDisplayed());
	   
	}
}
