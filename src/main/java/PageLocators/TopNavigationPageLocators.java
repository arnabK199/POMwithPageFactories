package PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationPageLocators {
	
	@FindBy(xpath="//button[@id='header-account-menu']")
	public WebElement accountTab;
	
	@FindBy(xpath="//a[@id='account-signin']")
	public WebElement signInBtn;
	
	@FindBy(xpath="//a[@id='account-register']")
	public WebElement createAccountBtn;
	
	

}
