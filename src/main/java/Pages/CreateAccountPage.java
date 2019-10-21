package Pages;

import org.openqa.selenium.support.PageFactory;

import BasePage.BaseTest;
import PageLocators.CreateAccountPageLocator;

public class CreateAccountPage extends BaseTest{
	
	public CreateAccountPageLocator capl ;
	
	public CreateAccountPage() {
		
		this.capl = new CreateAccountPageLocator();
		PageFactory.initElements(driver, this.capl);
		
	}
	
	public void createAccount(String fname , String surname , String email , String password ) {


		type(this.capl.firstName,fname);
		type(this.capl.surName,surname);
		type(this.capl.email,email);
		type(this.capl.password,password);
	    click(this.capl.signUp);

		
	}

}
