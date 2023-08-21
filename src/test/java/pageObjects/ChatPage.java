package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilties.Helper;


public class ChatPage {
	
		public static ExtentHtmlReporter htmlReporter;
	   public static ExtentReports extent;
	   public static ExtentTest test;
	    
	    
	    public static void config() {
	    	
	    	htmlReporter = new ExtentHtmlReporter("test-output/MyOwnReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }
	
	WebDriver ldriver;
	public Logger logger;
	public ChatPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//textarea[@class='form-control']")
	WebElement chatBox;	
	
	@FindBy(xpath = "//button[@class='btn-start btn btn-alpha']")
	WebElement startLiveChatBtn;
	
	@FindBy(xpath="//div[@class='message-box']/p")
	List<WebElement> message;
	
	@FindBy(xpath="//textarea[@class='form-control input dialog-input']")
	WebElement chatBoxNew;
	
	@FindBy(xpath="//button[@class='dialog-submit-btn btn btn-alpha']")
	WebElement sendBtn;
	
	@FindBy(xpath = "//button[@class='dialog-submit-btn btn btn-invert-beta']")
	WebElement endChatBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-beta close-submit-btn-yes']")
	WebElement confirmYes;
	
	
	public void startLiveChat(String chatText) throws InterruptedException {
		
		Helper.enterText(chatBox, chatText);
		Helper.clickWebElement(startLiveChatBtn);
		Thread.sleep(15000);
		Helper.enterText(chatBoxNew, "This is the Test Chat, Thank You!");
		Helper.clickWebElement(sendBtn);
	}
	
	public void getChatHistory() {
		
		logger = Logger.getLogger("O2Chat");
		PropertyConfigurator.configure("Log4j.properties");
		for(WebElement ele: message) {			
			
			String msgSender = ele.getAttribute("class");
			String msgText = ele.getAttribute("innerHTML");
			ExtentCucumberAdapter.addTestStepLog("Message send by "+msgSender);
			ExtentCucumberAdapter.addTestStepLog("Message Details "+msgText);	
			if(msgSender.equals("dialog-message-customer")) {
				
				List<WebElement> textList = ele.findElements(By.xpath("//div[@class='message-box']/p/span[@class='text']"));
				for(WebElement eleText : textList) {
					
					String senderText = eleText.getAttribute("innerHTML");
					ExtentCucumberAdapter.addTestStepLog("Customer Message: "+senderText);
				}
			}
			if(msgSender.equals("dialog-message-agent")) {
				
				List<WebElement> textList = ele.findElements(By.xpath("//div[@class='message-box']/p/span[@class='text']"));
				for(WebElement eleText : textList) {
					
					String agentReply = eleText.getAttribute("innerHTML");
					ExtentCucumberAdapter.addTestStepLog("Agent Reply: "+agentReply);
				}
			}
		}
	}
	
	public void endChat() throws InterruptedException {
		
		Thread.sleep(10000);
		Helper.clickWebElement(endChatBtn);
		Helper.clickWebElement(confirmYes);
		
		Assert.assertEquals(false, sendBtn.isEnabled());
	}
	

}
