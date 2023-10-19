package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EllimentUtils {
	
	WebDriver driver;
	
	public EllimentUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	// without using webdriverwait generic method
	public void clickOnElement(WebElement element, long durationTime)
	{   
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationTime));
		WebElement we=wait.until(ExpectedConditions.elementToBeClickable(element));
		 
		we.click();
	}
	// without using webdriverwait generic method
	public void typeTextIntoField(WebElement element,long duarationTime, String typeText)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(duarationTime));
		WebElement we=wait.until(ExpectedConditions.elementToBeClickable(element));
		we.click();
		we.clear();we.sendKeys(typeText);
		
	}
	
	//WebDriverWait generic method
	// Insted of writing webDriverwait try to call below generic methods
	
	public WebElement waitForElement(WebElement element,long durationTime)
	{ 
		WebElement we=null;
		
		try {
			
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationTime));
	  we= wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return we;
	}
	
	
	// with using webdriverwait generic method
		public void typeTextIntoFieldUsingWithGeneric(WebElement element,long duarationTime, String typeText)
		{
			
			WebElement we=waitForElement(element,duarationTime);
			we.click();
			we.clear();
			we.sendKeys(typeText);
	
		}
		
		
		// with using webdriverwait generic method
		public void clickOnElementwithGeneric(WebElement element, long durationTime)
		{   
			
			WebElement we=waitForElement(element,durationTime);
			 
			we.click();
		}
	   // select dropDown
		public void selectOptionsInDropdown(WebElement element, String selectType,long durationTime)
		{ 
			Select sc=new Select(element);
			sc.deselectByVisibleText(selectType);
		}
		
		//Accept alert
		public void acceptAlert(long durationTime)
		{
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}	
		
		//waitforAlert
			
		public Alert waitForAlert(long durationTime)
			{ 
				Alert alt=null;
				try {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationTime));
				alt=wait.until(ExpectedConditions.alertIsPresent());
			}
			catch(Throwable e)
			{  
				e.printStackTrace();
				}
				return alt;
			}
		
		//MouseHoverAndCleckElement
		public void mouseHoverAndClickElement(WebElement element,long DurationTime)
		{  
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(DurationTime));
			WebElement we=wait.until(ExpectedConditions.visibilityOf(element));
			
			Actions action=new Actions(driver);
			action.moveToElement(we).click().build().perform();
		}
		
		//or
		
		public void mouseHoverAndClickElementIwithGeneric(WebElement element,long DurationTime)
		{  
			
			WebElement we=waitForVisibilityElement(element,DurationTime);
			
			Actions action=new Actions(driver);
			action.moveToElement(we).click().build().perform();
		}
		
		
		
		//waitforvisibilityofelement
		public WebElement waitForVisibilityElement(WebElement elemet,long durationTime)
		{	
			WebElement we=null;
			
			try
			{ WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(durationTime));
			we=wait.until(ExpectedConditions.visibilityOf(elemet));
			}catch(Throwable e)
			{
				e.printStackTrace();
			}
			
			return we;
		}
		
		
		public void javaScriptClick(WebElement elemet,long durationTime)
		{
			WebElement we=waitForVisibilityElement(elemet,durationTime);
			
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("argumens[0].click()", we);
		}
		
		public void javaScriptTypeText(WebElement elemet,long durationTime)
		{
			WebElement we=waitForVisibilityElement(elemet,durationTime);
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("arguments[0].value='"+we+"'", we);
		}
		
		public String getTextFromElement(WebElement element, long durationTime)
		{
			WebElement we=waitForElement(element,durationTime);
			
			return  we.getText();
		}
		
		public boolean displayStatusOfElement(WebElement elemet,long durationTime)
		{ 	WebElement we=null;
			try {
			we=waitForVisibilityElement(elemet,durationTime);
			return we.isDisplayed();
			}
			catch (Exception e) {
				return false;
			}
			
			
		}
		
		
		
		
		}
		
	
