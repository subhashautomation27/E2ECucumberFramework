package stepdefinitions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage1;
import pages.LoginPage1;
import utils.Commanutils;


public class LoginPage {
	WebDriver driver ;
	
	 private HomePage1 hm ;
	private  LoginPage1 lp;
	private AccountPage ap;
	private Commanutils cutil;
	
	@Given("user navigates to the login page")
	public void user_navigates_to_the_login_page() {
		
		 driver = DriverFactory.getDriver();
		 hm=new HomePage1(driver);
		 hm.clickOnMyAccount();
		 hm.clickOnLoginlink();
		 
		 	   
	}
	
	@When("user has entered the email address {string} into email field")
	public void user_has_entered_the_email_address_into_email_field(String emailAddress) {
		
		lp=new LoginPage1(driver);
		lp.enterEmail(emailAddress);
		
	}

	@And("user has entered the password {string} into password field")
	public void user_has_entered_the_password_into_password_field(String password) {
		lp.enterPws(password);
		
	}
	@And("user has clicks the login  button")
	public void user_has_clicks_the_login_button() {
		lp.clickSubmitBtn();
	   
	}

	@Then("user should get succesfully logged in")
	public void user_should_get_succesfully_logged_in() {
		
		 ap=new AccountPage(driver);
		boolean bb= ap.get_Edit_your_account_information();
		 
		Assert.assertTrue(bb );
	   
	}

	
	@Then("user should get warnning messages about No match for E-Mail Address and\\/or Password")
	public void user_should_get_warnning_messages_about_no_match_for_e_mail_address_and_or_password() {
		lp=new LoginPage1(driver);
		String name=lp.geterrorMessage();
		Assert.assertEquals(name, "Warning: No match for E-Mail Address and/or Password.");
	   
	}

	@When("user has not entered email addres into email field")
	public void user_has_not_entered_email_addres_into_email_field() {
		lp=new LoginPage1(driver);
		lp.enterEmail("");
		
	   
	}

	@And("user has not entered the password into password field")
	public void user_has_not_entered_the_password_into_password_field() {
		
		
		lp.enterPws("");
	    
	}
	
	

	@When("user has entered the invalid  email address into email field")
	public void user_has_entered_the_invalid_email_address_into_email_field() {
		lp=new LoginPage1(driver);
		cutil=new Commanutils();
		lp.enterEmail(cutil.getEmailTimeStamp());
		
	    
	}

	

	@And("user has entered the invalid  password {string} into password field")
	public void user_has_entered_the_invalid_password_into_password_field(String password) {
		lp.enterPws(password);
	    
	}




}
