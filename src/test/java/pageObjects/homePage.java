package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilties.Helper;

public class homePage {
	
	WebDriver ldriver;
	
	public homePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@title='o2 Service Live-Chat']")
	WebElement serviceChatLink;
	
	public void clickServiceChatLink() {
		//helper = new Helper();
		Helper.clickWebElement(serviceChatLink);
		
	}

}
