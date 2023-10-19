package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.configReader;

public class MyHooks {

	public WebDriver driver;
	Properties prop ;

	@Before
	public void startup() {
		
		prop = configReader.initlizeProperties();
		DriverFactory.initilizeBrowser(prop.getProperty("browser"));
		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configReader.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configReader.PAGELOAD_TIMEOUT));
		driver.get(prop.getProperty("url"));
	}

	@After
	public void tearDown() {
		
		driver.quit();
	}

}
