package stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;

public class ChatViaLogin extends BaseClass{
	
		WebDriver driver;
		
		//Scenario 2
		@Then("Click Chat Icon")
		public void click_chat_icon() throws InterruptedException {
			
			Thread.sleep(5000);
		    
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement phoneIcon = (WebElement)js.executeScript("return document.querySelector(\"#id-780502\").shadowRoot.querySelector(\"div > div > div > div\")");

			js.executeScript("arguments[0].click();", phoneIcon);
			
			Thread.sleep(5000);
		}

		@Then("Start chat with Aura")
		public void start_chat_with_aura() {
		    
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement aura = (WebElement)js.executeScript("return document.querySelector(\"#id-710514 > a > span:nth-child(2) > span.title\")");

			wait.until(ExpectedConditions.elementToBeClickable(aura));
			js.executeScript("arguments[0].click();", aura);
			
		}

		@Then("Write the keyword to initiate the chat {string}")
		public void write_the_keyword_to_initiate_the_chat(String string) {
		    
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement chatWindow = (WebElement)js.executeScript("return document.querySelector(\"#twc-user-input-field\")");

			js.executeScript("document.getElementByID("+chatWindow+").value = "+string);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			WebElement arrowIcon = (WebElement)js.executeScript("return document.querySelector(\"#twc-user-input__send-icon > g > path\")");

			jse.executeScript("arguments[0].click();", arrowIcon);
		}


}
