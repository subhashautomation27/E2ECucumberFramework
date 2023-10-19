

package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage1;
import pages.RegisterPage1;
import pages.SuccessPage;
import utils.Commanutils;

public class RegisterPage {
	
	WebDriver driver;
	private HomePage1 hp;
	private RegisterPage1 rp;
	private SuccessPage sp;
	private Commanutils cutil;
	
	@Given("user navigates the register page")
	public void user_navigates_the_register_page() {
		
		driver = DriverFactory.getDriver();
		
		 hp=new HomePage1(driver);
		hp.clickOnMyAccount();
		hp.clickOnRegisterLink();
    
	}

	@When("user has enters the below details into fileds")
	public void user_has_enters_the_below_details_into_fileds(DataTable dataTable) {
		cutil=new Commanutils();;
		Map<String, String> data = dataTable.asMap(String.class,String.class);
		rp=new RegisterPage1(driver);
		rp.enterFirstName(data.get("firstName"));
		rp.enterLastName(data.get("lastName"));
		rp.enterEmailAddress(cutil.getEmailTimeStamp());
		rp.enterTelephoneNumber(data.get("telephone"));
		rp.enterpassword(data.get("password"));
		rp.enterConfirmpassword(data.get("confirm_password"));
		
		
}
	
	@When("user has enters the details into below fileds with dupilicate email")
	public void user_has_enters_the_details_into_below_fileds_with_dupilicate_email(DataTable dataTable) {
		
		Map<String, String> data = dataTable.asMap(String.class,String.class);
		
		rp=new RegisterPage1(driver);
		rp.enterFirstName(data.get("firstName"));
		rp.enterLastName(data.get("lastName"));
		rp.enterEmailAddress(data.get("email"));
		rp.enterTelephoneNumber(data.get("telephone"));
		rp.enterpassword(data.get("password"));
		rp.enterConfirmpassword(data.get("confirm_password"));

}

	@And("user select the privacy policy")
	public void user_select_the_privacy_policy() {
		rp.clickPrivaciPolicy();
		
	 }

	@And("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		rp.clickOnContinueBtn();
		
		   
	}

	@Then("user account should get created succesfully")
	public void user_account_should_get_created_succesfully() {
		
		 sp=new SuccessPage(driver);
	    Assert.assertEquals("Register Account", sp.getAccountHasBeenCreatedText());
	}

	@And("user select the yes for Newletter")
	public void user_select_the_yes_for_newletter() {
		
		rp.clickOnNewsLetterRadilBtn();
		
	   }

	@Then("user should get proper warning message about dupilicate email")
	public void user_should_get_proper_warning_message_about_dupilicate_email() {
		
		 rp=new RegisterPage1(driver);
		 
		 Assert.assertEquals(rp.getDupilicateErrorMessage(), "Warning: E-Mail Address is already registered!");
		
		
	    
	}

	@When("user dont enters the any details into fileds")
	public void user_dont_enters_the_any_details_into_fileds() {
		
		rp=new RegisterPage1(driver);
		rp.enterFirstName("");
		rp.enterLastName("");
		rp.enterEmailAddress("");
		rp.enterTelephoneNumber("");
		rp.enterpassword("");
		rp.enterConfirmpassword("");
	    
	}

	@Then("user should get proper warning message about every mandatory fileds")
	public void user_should_get_proper_warning_message_about_every_mandatory_fileds() {
		rp=new RegisterPage1(driver);
		Assert.assertTrue(rp.firstNameSizeErrorMessage().equals("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(rp.lasyNamesizeErrorMessage().equals("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(rp.emailErrorMessage().equals("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(rp.telephoneNumberErrorMessage().equals("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(rp.passwordErrorMessage().equals("Password must be between 4 and 20 characters!"));
		
		
	    
	}
	
	

}
