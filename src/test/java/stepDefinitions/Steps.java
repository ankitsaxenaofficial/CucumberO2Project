package stepDefinitions;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pageObjects.*;

public class Steps {

	
	WebDriver driver = new ChromeDriver();
	homePage homeP = new homePage(driver);
	loginPage loginP = new loginPage(driver);

	
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


	@Then("Update the Url {string}") public void update_the_url(String
			updatedUrl) {

		Set<String> Child_id = driver.getWindowHandles(); for(String win: Child_id) {
			driver.switchTo().window(win); }

		driver.get(updatedUrl); 
	}
 

	@Then("click LoginButton")
	public void click_login_button() {

		loginP.Login();
	}

	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String uName, String pwd) {

		loginP.loginByRefNum(uName, pwd);

	}

	@When("Click on Login")
	public void click_on_login() {

	}

	@Then("verify the title")
	public void verify_the_title() {

	}

	@Then("close the browser")
	public void close_the_browser() {

		driver.quit();
	}


}
