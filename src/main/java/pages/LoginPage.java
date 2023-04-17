package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverSetUp;


public class LoginPage {
	
	
	
	@FindBy(xpath="//input[@name='IDToken1']") WebElement userName;
	@FindBy(xpath="//input[@name='IDToken2']") WebElement password;
	@FindBy(id="login-btn") WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		
	PageFactory.initElements(DriverSetUp.getDriver(),this);
		
			
	}
	
	public void login(String username, String pasword) {
		userName.sendKeys(username);
		//password.sendKeys(password);
		
	}
	
	
	

}
