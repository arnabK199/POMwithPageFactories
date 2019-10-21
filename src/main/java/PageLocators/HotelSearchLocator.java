package PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelSearchLocator {
	
	
	@FindBy(xpath="//input[@id='hotel-destination-hp-hotel']")
	public WebElement hotelField;
	
	@FindBy(xpath="//input[@id='hotel-checkin-hp-hotel']")
	public WebElement checkInDateField;
	
	@FindBy(xpath="//button[@data-month='7'][@data-day='24']")
	public WebElement checkInDate;
	
	@FindBy(xpath="//input[@id='hotel-checkout-hp-hotel']")
	public WebElement checkOuDateField;
	
	@FindBy(xpath="//button[@data-month='8'][@data-day='13']")
	public WebElement checkOutDate;
	
	@FindBy(xpath="(//button[@data-gcw-component=\"gcw-traveler-amount-select\"])[3]")
	public WebElement travellersField;
	
	@FindBy(xpath="//div[@class='traveler-selector-room-data']/div[2]/div[4]")
	public WebElement addIncr;
	
	@FindBy(xpath="//div[@class='traveler-selector-room-data']/div[3]/div/div[4]")
	public WebElement childInc;
	
	@FindBy(xpath="//li[contains(@class,'open')]//button[contains(@class,'close btn-text')]")
	public WebElement closeTrav;
	
	@FindBy(xpath="//input[@id='hotel-add-flight-checkbox-hp-hotel']")
	public WebElement addFlight;
	
	@FindBy(xpath="//form[@id='gcw-hotel-form-hp-hotel']//button[contains(@class,'gcw-submit')]  ")
	public WebElement searchField;
	
	
	
}
