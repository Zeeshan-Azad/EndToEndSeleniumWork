package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
public static WebDriver launchBrowser(String browserName) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--headless");
		
		WebDriver driver;
		
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
				driver = new ChromeDriver(options);		
				WebDriverManager.chromedriver().setup();
			}
			else if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
				driver = new FirefoxDriver();
				
			}
			else if(browserName.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			}
			else {
				driver = null;						
			}		
			return driver;
			
	}
}
