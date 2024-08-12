package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.OrangeHrmLoginPage;
import testBase.BaseTest;

public class TestLoggingInWithRandomCreds extends BaseTest {
	

	@Test
	public void loginAsRandomUser() {
		String userName = randomStringCreator();
		String password = randomAlphaNumericCreator();
		OrangeHrmLoginPage orangeHrmLoginPage = new OrangeHrmLoginPage(driver);
		orangeHrmLoginPage.login(userName, password);
	}
	
	
	@Test(dependsOnMethods = "loginAsRandomUser")
	public void verifyLogin() {
		String urlHomePage = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String urlLandedTo = driver.getCurrentUrl();
		//boolean loginSuccess = urlLandedTo.equals(urlHomePage);
		Assert.assertEquals(urlLandedTo, urlHomePage);
	}
}
