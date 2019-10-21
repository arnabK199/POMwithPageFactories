package PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPageLocators {
	
	
	
	@FindBy(xpath="//input[@id='gss-signin-email']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@id='gss-signin-password']")
	public WebElement passWord;
	
	@FindBy(xpath="//button[@id='gss-signin-submit']")
	public WebElement signInBtn;
	

}
