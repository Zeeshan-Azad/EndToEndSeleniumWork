package testBase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	
	public WebDriver driver;
	public ExtentReports extent;
    public ExtentTest test;
    
	@BeforeMethod
	@BeforeSuite
	public void setUp() {
		 ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(spark);
	}
	
	@AfterSuite
	public void flush() {
		extent.flush();
	}
	
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
