package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static WebDriver driver;
	
	public static void initilizeBrowser(String browserName)
	{
		
		if(browserName.equals("chrome"))
		{
			 driver=new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			 driver=new EdgeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			 driver=new FirefoxDriver();
		}
		
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}

}
