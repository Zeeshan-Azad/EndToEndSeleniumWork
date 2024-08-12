package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHrmLoginPage {
	WebDriver driver;
	
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameTextField;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextField;
	
	@FindBy(xpath="//button[.=' Login ']")
	WebElement loginButton;
	
	@FindBy(xpath="//p[.='Forgot your password? ']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[.='OrangeHRM, Inc']")
	WebElement orangeHrmLink;
	
	
	@FindBy(xpath="//p[.='Invalid credentials']")
	WebElement errorMessage;
	
	public OrangeHrmLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUserName(String userName) {
		userNameTextField.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickForgotPasswordLink() {
		forgotPasswordLink.click();
	}
	
	
	public void clickOrangeHrmLink() {
		//solution 1
		orangeHrmLink.click();
		
	}
	
	public void clickOrangeHrmLinkUsingKeyboard() {
		//solution 2
		Actions act = new Actions(driver);
		act.moveToElement(orangeHrmLink).click().perform();
	}
	
	public void clickOrangeHrmLinkUsingJSE() {
		//solution 3
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguements[0].click();", orangeHrmLink);
	}
	
	public void clickOrangeHrmLinkUsingWait() {
		//solution 4
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(orangeHrmLink)).click();
	}
	
	public void loginAsAdmin(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLoginButton();
	}
	
	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLoginButton();
	}
	
	public String showErrorMessage() {
		return errorMessage.getText();
	}
	
}
