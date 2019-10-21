package PageLocators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePageLocators {
	
	@FindBy(xpath="//button[@id='tab-flight-tab-hp']")
	public WebElement FlightTab;
	
	@FindBy(xpath="//button[@id='tab-hotel-tab-hp']")
	public WebElement HotelTab;
	
	
	@FindBy(xpath="//input[@id='flight-origin-hp-flight']")
	public WebElement fromSource;
	
	@FindBy(xpath="//input[@id='flight-destination-hp-flight']")
	public WebElement toDestination;
	
	
	@FindBys({
		@FindBy(xpath="(//div[@class='cols-nested'])[1]"),
		@FindBy(xpath="//input[@id='flight-departing-hp-flight']")
				})
	public WebElement departDateField;
	
	
	@FindAll({
		@FindBy(xpath ="//input[@id='flight-returning-hp1-flight']"),
		@FindBy(css=".text.datepicker-trigger-input.gcw-end-date.gcw-update-date-range.gcw-storeable.gcw-required.gcw-valid-date")
	})
	public WebElement returnDateField;
	
	@FindBy(css=".btn-primary.btn-action.gcw-submit")
	public WebElement searchBtn;
	
	@FindBy(xpath="//li[@role='presentation']")
	public List<WebElement> tabs; 
	
	@FindBy(xpath="//button[@data-month='7'][@data-day='24']")
	public WebElement departDate;
	
	@FindBy(xpath="//button[@data-month='8'][@data-day='13']")
	public WebElement returnDate;

	
	

}
