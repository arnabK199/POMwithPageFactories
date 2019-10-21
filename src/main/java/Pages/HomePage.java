package Pages;

import org.openqa.selenium.support.PageFactory;

import BasePage.BaseTest;
import PageLocators.HomePageLocators;

public class HomePage extends BaseTest{
	
	public HomePageLocators home;
	
	
	public HomePage() {
		
		this.home = new HomePageLocators();
		PageFactory.initElements(driver, this.home);
	}
	
	
	
	public HomePage goToFlights() {
		
		
		click(home.FlightTab);
		return new HomePage();
	}
	
	
	
	public HotelSearchPage goToHotels() {
		
		click(home.HotelTab);
		return new HotelSearchPage();
	}
	
	
	
	public void gotoHotelAndFlights() {
		
		
		
	}
	
	public void searchFlight(String source, String destination) {
		
		type(home.fromSource,source);
		type(home.toDestination,destination);
		click(home.departDateField);
		click(home.departDate);
		click(home.returnDateField);
		click(home.returnDate);
		click(home.searchBtn);
		
		
	}
	
	public int noOfTabs() {
		
		return home.tabs.size();
	}
	
	

}
