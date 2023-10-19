package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.EllimentUtils;

public class LoginPage1 {

	WebDriver driver;
	private EllimentUtils eutils;

	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eutils = new EllimentUtils(driver);
	}

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement clickSubmitBtn;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement noMatchEmailAndPAsswordErrorMsg;

	public void enterEmail(String emailText) {
		eutils.typeTextIntoFieldUsingWithGeneric(email, 30, emailText);

	}

	public void enterPws(String pwdText) {
		eutils.typeTextIntoFieldUsingWithGeneric(password, 30, pwdText);

	}

	public AccountPage clickSubmitBtn() {
		eutils.clickOnElementwithGeneric(clickSubmitBtn, 30);

		return new AccountPage(driver);
	}

	public String geterrorMessage() {
		return eutils.getTextFromElement(noMatchEmailAndPAsswordErrorMsg, 30);

	}

}
