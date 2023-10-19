package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage1;

public class HomePage {

	WebDriver driver;

	private HomePage1 hp;

	@Given("user naigates home page")
	public void user_naigates_home_page() {

		driver = DriverFactory.getDriver();

	}

	@When("user able to see the {string} on home page")
	public void user_able_to_see_the_on_home_page(String string) {

		hp = new HomePage1(driver);
		Assert.assertTrue(hp.ApplicationLogoDisplayed());

	}

	@Then("user successfully get dispalyed tilte of the application")
	public void user_successfully_get_dispalyed_tilte_of_the_application() {

		System.out.println(hp.getApplicationLogo());

		String logo = driver.findElement(By.linkText("Qafox.com")).getText();
		System.out.println("page logo is : " + logo);

	}

}
