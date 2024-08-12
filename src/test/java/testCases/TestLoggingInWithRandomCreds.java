package testCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.OrangeHrmLoginPage;
import testBase.BaseTest;

public class TestLoggingInWithRandomCreds extends BaseTest {
	

	@Test
	public void loginAsRandomUser() {
		test = extent.createTest("Trying to login as random user");
		String userName = randomStringCreator();
		String password = randomAlphaNumericCreator();
		OrangeHrmLoginPage orangeHrmLoginPage = new OrangeHrmLoginPage(driver);
		orangeHrmLoginPage.login(userName, password);
		test.pass("invalid credentials provided. Checking for authentication");
	}
	
	
	@Test(dependsOnMethods = "loginAsRandomUser")
	public void verifyLogin() {
		test = extent.createTest("verifying logging with random user");
		String urlHomePage = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String urlLandedTo = driver.getCurrentUrl();
		//boolean loginSuccess = urlLandedTo.equals(urlHomePage);
		AssertJUnit.assertEquals(urlLandedTo, urlHomePage);
		test.pass("invalid user could not login. Test Passed");
	}
}
