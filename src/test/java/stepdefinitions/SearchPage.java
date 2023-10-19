package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage1;
import pages.SearchPage1;

public class SearchPage {

	WebDriver driver;
	private HomePage1 hp;
	private SearchPage1 sp;

	@Given("user navigates the homepage")
	public void user_navigates_the_homepage() {

		driver = DriverFactory.getDriver();
		
	}

	@When("user has entered the product {string} into search field")
	public void user_has_entered_the_product_into_search_field(String string) {
		hp=new HomePage1(driver);
		hp.searchTextBox(string);

	}
	
	@When("user has entered the invalid product {string} into search field")
	public void user_has_entered_the_invalid_product_into_search_field(String string) {
		hp=new HomePage1(driver);
		hp.searchTextBox(string);

	}

	@And("user clicks on search button")
	public void user_clicks_on_search_button() {
		hp=new HomePage1(driver);
		hp.clickOnSearchBtn();

	}

	@Then("user should get valid product information successfuly")
	public void user_should_get_valid_product_information_successfuly() {

		sp = new SearchPage1(driver);
		
		Assert.assertTrue( sp.ValidProductsearchresult());
		//"searched product in not matched"
		
	}

	@Then("user should get warring message about There is no product that matches the search criteria")
	public void user_should_get_warring_message_about_there_is_no_product_that_matches_the_search_criteria() {

		sp = new SearchPage1(driver);
		Assert.assertEquals(sp.invalidProducuSearchresult(), "There is no product that matches the search criteria.");

	}

	@When("user not  entered the product into search field")
	public void user_not_entered_the_product_into_search_field() {

		hp = new HomePage1(driver);
		hp.clickOnSearchBtn();
		hp.searchTextBox("");
		
	}

}
