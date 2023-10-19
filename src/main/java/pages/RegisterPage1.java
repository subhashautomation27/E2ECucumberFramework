package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.EllimentUtils;

public class RegisterPage1 {

	WebDriver driver;
	private EllimentUtils eutils;

	public RegisterPage1(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		eutils = new EllimentUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telePhone;

	@FindBy(id = "input-password")
	private WebElement pwd;

	@FindBy(id = "input-confirm")
	private WebElement confirmPWD;

	@FindBy(name = "agree")
	private WebElement privacyPolicy;

	@FindBy(name = "newsletter")
	private WebElement NewsLeeterRadioBtn;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement dupilicateEmailErrorMesage;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement clickOnContinue;

	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameMustErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNamesizeErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephoneNumberErrorMessage;

	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordErrorMessage;

	public String passwordErrorMessage() {
		return eutils.getTextFromElement(passwordErrorMessage, 30);

	}

	public String telephoneNumberErrorMessage() {
		return eutils.getTextFromElement(telephoneNumberErrorMessage, 30);

	}

	public String emailErrorMessage() {
		return eutils.getTextFromElement(emailErrorMessage, 30);

	}

	public String lasyNamesizeErrorMessage() {
		return eutils.getTextFromElement(lastNamesizeErrorMessage, 30);

	}

	public String firstNameSizeErrorMessage() {
		return eutils.getTextFromElement(firstNameMustErrorMessage, 30);

	}

	public void enterFirstName(String fName) {
		eutils.typeTextIntoFieldUsingWithGeneric(firstName, 30, fName);

	}

	public void enterLastName(String lName) {
		eutils.typeTextIntoFieldUsingWithGeneric(lastName, 30, lName);

	}

	public void enterEmailAddress(String emailText) {
		eutils.typeTextIntoFieldUsingWithGeneric(email, 30, emailText);

	}

	public void enterTelephoneNumber(String Phonetext) {
		eutils.typeTextIntoFieldUsingWithGeneric(telePhone, 30, Phonetext);

	}

	public void enterpassword(String pwdText) {
		eutils.typeTextIntoFieldUsingWithGeneric(pwd, 30, pwdText);

	}

	public void enterConfirmpassword(String confirmPwdText) {
		eutils.typeTextIntoFieldUsingWithGeneric(confirmPWD, 30, confirmPwdText);

	}

	public void clickPrivaciPolicy() {
		eutils.clickOnElementwithGeneric(privacyPolicy, 30);

	}

	public SuccessPage clickOnContinueBtn() {
		eutils.clickOnElementwithGeneric(clickOnContinue, 30);

		return new SuccessPage(driver);
	}

	public void clickOnNewsLetterRadilBtn() {
		eutils.clickOnElementwithGeneric(NewsLeeterRadioBtn, 30);

	}

	public String getDupilicateErrorMessage() {
		return eutils.getTextFromElement(dupilicateEmailErrorMesage, 30);

	}

}
