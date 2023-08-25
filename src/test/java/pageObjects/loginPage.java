package pageObjects;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilties.Helper;

public class loginPage {
	
	
	WebDriver ldriver;
	
	@FindBy(xpath = "(//button[text()='Login'])[2]")
	WebElement loginBtn;
	
	@FindBy(id="IDToken1")
	WebElement userName;
	
	@FindBy(id="login-username-submit-button")
	WebElement furtherBtn;
	
	@FindBy(id="login-password-submit-button")
	WebElement loginBtnAfterPwd;
	
	public loginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		ldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	public void Login() throws InterruptedException {
		
		
		Set<String> Child_id = ldriver.getWindowHandles(); 
		for(String win: Child_id) {
			
		ldriver.switchTo().window(win);
			Thread.sleep(10000);
		}
		
		Helper.clickWebElement(loginBtn);
		if(!ldriver.getCurrentUrl().contains("/auth/login?"))
			Helper.clickWebElement(loginBtn);
	}
	
	public void loginByRefNum(String uName, String pwd) {
		
		Helper.enterText(userName, uName);
		Helper.clickWebElement(furtherBtn);
		Helper.enterText(userName, pwd);
		Helper.clickWebElement(loginBtnAfterPwd);
	}
}
