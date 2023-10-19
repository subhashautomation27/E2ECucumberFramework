package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.EllimentUtils;

public class AccountPage {

	WebDriver driver;
	private EllimentUtils eutils;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eutils = new EllimentUtils(driver);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement Edit_your_account_information_link;

	public boolean get_Edit_your_account_information() {
		return eutils.displayStatusOfElement(Edit_your_account_information_link, 30);

	}

}
