package automation.stepDefinitions;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import automation.assertions.Compare;
import automation.base.CreateDriverInstance;
import automation.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	
	WebDriver driver;
	LoginPage login;
	ResourceBundle config = ResourceBundle.getBundle("config");
	CreateDriverInstance driverInstance = new CreateDriverInstance();
	Compare com = new Compare();
	
	@Given("^User is in login page$")
	public void userLoginPage() throws Throwable 
	{
		driver = driverInstance.genrateDriverInstance();	
		Thread.sleep(10000);
	}

	@When("^User enter user$")
	public void enterUser() throws Throwable 
	{	
		Assert.assertTrue(com.validatePageURL(driver, "https://s1.demo.opensourcecms.com/s/44"));	
		login = new LoginPage(driver);		
		login.enterUsername(config.getString("username"));
	}

	@When("^User enter password$")
	public void enterPassword() throws Throwable 
	{
		Assert.assertTrue(com.validateElementExistByXpath(driver, "//input[@id='txtPassword']"));	
		login.enterPassword(config.getString("password"));
	}

	@Then("^User logged in successfully$")
	public void userLoggin() throws Throwable 
	{
		login.login();
		Thread.sleep(6000);
		driverInstance.closeDriver(driver);
	}
}
