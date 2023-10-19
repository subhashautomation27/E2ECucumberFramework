package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.EllimentUtils;

public class SearchPage1 {

	WebDriver driver;
	private EllimentUtils eutils;

	public SearchPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eutils = new EllimentUtils(driver);
	}

	@FindBy(xpath = "//*[text()='HP LP3065']")
	private WebElement ValidProductsearchresult;

	@FindBy(xpath = "(//div[@id='content']//p)[2]")
	private WebElement invalidProductSearchResult;

	public String invalidProducuSearchresult() {
		return eutils.getTextFromElement(invalidProductSearchResult, 30);

	}

	public boolean ValidProductsearchresult() {
		return eutils.displayStatusOfElement(ValidProductsearchresult, 30);

	}

}
