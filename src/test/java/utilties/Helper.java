package utilties;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {
	
	public static WebDriver driver;
	static WebElement element;
	public static void clickWebElement(WebElement ele) {
		
		element = ele;
		ele.click();
		
	}
	
	public static void enterText(WebElement ele, String text) {
		
		element=ele;
		ele.sendKeys(text);
	}

	
	public static void switchToLatestWindow() {
		Set<String> Child_id = driver.getWindowHandles(); 
		for(String win: Child_id) {
		driver.switchTo().window(win);
		}
	}
}
