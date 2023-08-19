package utilties;

import org.openqa.selenium.WebElement;

public class Helper {
	
	static WebElement element;
	public static void clickWebElement(WebElement ele) {
		
		element = ele;
		ele.click();
		
	}
	
	public static void enterText(WebElement ele, String text) {
		
		element=ele;
		ele.sendKeys(text);
	}

}
