package TestCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePage.BaseTest;
import Pages.HomePage;
import Pages.HotelSearchPage;
import Utilities.ExcelReader;
import Utilities.TestUtil;

public class HotelSearchTest {
	
	public static ExcelReader reader= null;
	
	
	@Test(dataProvider="getdata")
	public void hotelSearhTest(Hashtable<String , String > data) throws IOException {
		
		if(!TestUtil.isrunnable("HotelSearchTest", reader)) {
			throw new SkipException("Skipping the test as the Run mode is NO");
		}

		if (data.get("runmode").equalsIgnoreCase("N")) {

			throw new SkipException("Skipping the test as the Run mode is NO");
		}
		
		BaseTest.initConfig();
		HomePage hp = new HomePage();
		hp.verifyEquals(7, hp.noOfTabs());
		
		HotelSearchPage hsp = hp.goToHotels();
		hsp.searchHotels(data.get("destination"), Integer.parseInt(data.get("adults").replace(".0", "")), Integer.parseInt(data.get("child").replace(".0", "")));
		
	}
	
	@AfterMethod
	public void teardown() {

		if (BaseTest.driver != null) {
			BaseTest.tearDown();
		}
	}

	@DataProvider
	public Object[][] getdata() {

		String sheetName = "HotelSearchTest";

		reader = BaseTest.getreader();

		int rowNum = reader.getRowCount(sheetName);
		int colNum = reader.getColumnCount(sheetName);

		Object[][] data = new Object[rowNum - 1][1];

		Hashtable<String, String> table = null;

		for (int row = 2; row <= rowNum; row++) {
			table = new Hashtable<String, String>();
			for (int col = 0; col < colNum; col++) {
				table.put(reader.getCellData(sheetName, col, 1), reader.getCellData(sheetName, col, row));
				data[row - 2][0] = table;
			}

		}

		return data;
	}
	
	
}
