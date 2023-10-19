package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.EllimentUtils;

public class HomePage1 {

	WebDriver driver;
	private EllimentUtils eutils;

	public HomePage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eutils = new EllimentUtils(driver);

	}

	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAccountlink;

	@FindBy(linkText = "Login")
	private WebElement clickOnLoginLink;

	@FindBy(linkText = "Register")
	private WebElement ClickregisterLink;

	@FindBy(name = "search")
	private WebElement searchBoxlink;

	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement clickOnSearchBtn;

	@FindBy(linkText = "Qafox.com")
	private WebElement applicationlogo;

	public boolean ApplicationLogoDisplayed() {
		/*
		 * eutils=new EllimentUtils(driver);
		 * 
		 * return eutils.displayStatusOfElement(applicationlogo, 10);
		 */
		return eutils.displayStatusOfElement(applicationlogo, 30);

	}

	public String getApplicationLogo() {
		return eutils.getTextFromElement(applicationlogo, 30);

	}

	public void ClickOnsearchBox() {
		eutils.clickOnElement(searchBoxlink, 30);

	}

	public void searchTextBox(String searchText) {
		eutils.typeTextIntoFieldUsingWithGeneric(searchBoxlink, 30, searchText);

	}

	public SearchPage1 clickOnSearchBtn() {

		eutils.clickOnElementwithGeneric(clickOnSearchBtn, 30);
		return new SearchPage1(driver);
	}

	public void clickOnMyAccount() {
		eutils.clickOnElementwithGeneric(myAccountlink, 30);

	}

	public void clickOnLoginlink() {
		eutils.clickOnElementwithGeneric(clickOnLoginLink, 30);

	}

	public void clickOnRegisterLink() {
		eutils.clickOnElementwithGeneric(ClickregisterLink, 30);

	}
}
