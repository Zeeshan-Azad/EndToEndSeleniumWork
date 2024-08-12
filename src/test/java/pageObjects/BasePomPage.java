package pageObjects;

import org.openqa.selenium.WebDriver;

public class BasePomPage {
	
	public WebDriver driver;
	
	public OrangeHrmLoginPage orangeHrmLoginPage;
	
	public BasePomPage() {
		createPageInstance();
	}
	
	public void createPageInstance(){
		orangeHrmLoginPage = new OrangeHrmLoginPage(driver);
	}
}
