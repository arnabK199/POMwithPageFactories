package PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageLocator {
	
	@FindBy(xpath="//input[@id='gss-signup-first-name']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='gss-signup-last-name']")
	public WebElement surName;
	
	@FindBy(xpath="//input[@id='gss-signup-email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@id='gss-signup-password']")
	public WebElement password;
	
	@FindBy(xpath="//button[@id='gss-signup-submit']")
	public WebElement signUp;

}
