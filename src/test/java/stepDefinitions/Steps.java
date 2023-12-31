package stepDefinitions;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;
import pageObjects.*;

public class Steps extends BaseClass {

	homePage homeP = new homePage(driver);
	loginPage loginP = new loginPage(driver);
	ChatPage chatP = new ChatPage(driver);

	//Scenario 1 - Chat Route
	@Given("User Launch Browser and opens URL {string}")
	public void user_launch_browser_and_opens_url(String url) throws InterruptedException {
		
		  
		  driver.get(url); 
		  driver.manage().window().maximize(); Thread.sleep(6000);
		 
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement acceptCookie = (WebElement)js.executeScript("return document.querySelector(\"#usercentrics-root\").shadowRoot.querySelector(\"#uc-center-container > div > div.sc-iTVJFM.dIhOzs > div > div > div > button:nth-child(3)\")");

		js.executeScript("arguments[0].click();", acceptCookie);
	}


	@When("User clicks on link O2 Service live chat")
	public void user_clicks_on_link_o2_service_live_chat() {

		homeP.clickServiceChatLink();		
	}

	@Then("click LoginButton")
	public void click_login_button() throws InterruptedException {

		switchToLatestWindow();
		loginP.Login();
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String uName, String pwd) {

		loginP.loginByRefNum(uName, pwd);

	}

	@Then("start the chat {string}")
	public void start_the_chat(String chatMsg) throws InterruptedException {
		
		chatP.startLiveChat(chatMsg);
	}
	
	@Then("Get Chat History")
	public void get_chat_history() {
	    
		chatP.getChatHistory();
	}

	@Then("End the Chat")
	public void end_the_chat() throws InterruptedException {
	    
		chatP.endChat();
	}
	@Then("close the browser")
	public void close_the_browser() {

		driver.quit();
	}
	
	
	
	public void switchToLatestWindow() {
		Set<String> Child_id = driver.getWindowHandles(); 
		for(String win: Child_id) {
		
				driver.switchTo().window(win);
		}
	}
			
		
}
