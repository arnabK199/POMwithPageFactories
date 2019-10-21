package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BasePage.BaseTest;
import PageLocators.TopNavigationPageLocators;

public class TopNavigationPage{
	
	public TopNavigationPageLocators topNav;
	
	public TopNavigationPage(WebDriver driver) {
		
		this.topNav= new TopNavigationPageLocators();
		PageFactory.initElements(BaseTest.driver, this.topNav);
		
	}
	
	public SignInPage gotoSignOption() {
		
		BaseTest.click(topNav.accountTab);
		BaseTest.click(topNav.signInBtn);
		
		return new SignInPage();
		
		
	}
	
	public CreateAccountPage gotoCreateAccountOption() {
		
		BaseTest.click(topNav.accountTab);
		BaseTest.click(topNav.createAccountBtn);
		
		return new CreateAccountPage();
	}

}
