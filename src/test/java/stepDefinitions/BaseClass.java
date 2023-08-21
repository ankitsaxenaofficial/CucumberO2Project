package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
	
}
	

