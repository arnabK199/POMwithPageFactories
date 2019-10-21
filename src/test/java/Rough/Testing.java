package Rough;

import BasePage.BaseTest;
import Pages.HomePage;

public class Testing {
	
	
	public static void main(String[] args) {
		
		
		BaseTest bt = new BaseTest();
		bt.initConfig();
		
		
		HomePage hp = new HomePage();
		hp.goToFlights().searchFlight("Kolkata, India (CCU-Netaji Subhash Chandra Bose Intl.)", "Delhi, India (DEL-Indira Gandhi Intl.)");
	}

}
