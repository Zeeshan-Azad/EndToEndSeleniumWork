package testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.OrangeHrmLoginPage;
import testBase.BaseTest;

public class TestLogginInAsAdmin extends BaseTest{
	
	
	@Test
	void verifyLoginAccuracy(){
		OrangeHrmLoginPage loginPage = new OrangeHrmLoginPage(driver);
		loginPage.loginAsAdmin("Admin", "admin123");
		String urlHomePage = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String urlLandedTo = driver.getCurrentUrl();
		//boolean loginSuccess = urlLandedTo.equals(urlHomePage);
		AssertJUnit.assertEquals(urlLandedTo, urlHomePage);
	}
}
