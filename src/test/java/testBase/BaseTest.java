package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() {
		 driver = BrowserFactory.launchBrowser("chrome");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 //return driver;
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}

		
	public String randomStringCreator() {
		String nameCreated = RandomStringUtils.randomAlphabetic(5);
		return nameCreated;
	}
	
	public String randomAlphaNumericCreator() {
		String valueCreated = RandomStringUtils.randomAlphabetic(8);
		String generatedNum = RandomStringUtils.randomNumeric(4);
		return (valueCreated+"@"+generatedNum);
	}
}
