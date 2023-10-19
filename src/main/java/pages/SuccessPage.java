package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.EllimentUtils;

public class SuccessPage {

	WebDriver driver;
	private EllimentUtils eutils;

	public SuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eutils = new EllimentUtils(driver);
	}

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement yourAccountHasBeenCreated;

	public String getAccountHasBeenCreatedText() {
		return eutils.getTextFromElement(yourAccountHasBeenCreated, 30);

	}

}
