package Pages;

import org.openqa.selenium.support.PageFactory;

import BasePage.BaseTest;
import PageLocators.SignInPageLocators;

public class SignInPage extends BaseTest{
	
	public SignInPageLocators signInLocator;
	
	
	public SignInPage() {
		
		this.signInLocator = new SignInPageLocators();
		PageFactory.initElements(driver, this.signInLocator);

	}
	
	
	public void SignIntoAccount(String userName , String passWord) {
		
		type(this.signInLocator.userName,userName);
		type(this.signInLocator.passWord,passWord);
		click(this.signInLocator.signInBtn);
		
	}

}
