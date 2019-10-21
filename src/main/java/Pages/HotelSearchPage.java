package Pages;

import org.openqa.selenium.support.PageFactory;

import BasePage.BaseTest;
import PageLocators.HotelSearchLocator;

public class HotelSearchPage extends BaseTest {

	public static HotelSearchLocator hotel = null;

	public HotelSearchPage() {

		this.hotel = new HotelSearchLocator();
		PageFactory.initElements(driver, this.hotel);
	}

	public void searchHotels(String hotelDestination , int noOfAdults , int noOfChild) {
		
		type(hotel.hotelField,hotelDestination);
		click(hotel.checkInDateField);
		click(hotel.checkInDate);
		click(hotel.checkOuDateField);
		click(hotel.checkOutDate);
		
		
		if(noOfAdults>2 || noOfChild>0) {
		
			click(hotel.travellersField);
			
		if(noOfAdults>2) {
			for(int i = 2; i<=noOfAdults;i++) {
				
				click(hotel.addIncr);
			}
		}
		
		if(noOfChild>0) {
			
	for(int j = 2; j<=noOfChild;j++) {
				
				click(hotel.childInc);
		}

			
		}
		
		click(hotel.closeTrav);
	
	}
		click(hotel.searchField);
		
		
	}
	

}
