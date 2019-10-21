package TestCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePage.BaseTest;
import Pages.HomePage;
import Utilities.ExcelReader;
import Utilities.TestUtil;

public class FlightSearchTest {
	public static ExcelReader reader = null;
	
	

	@Test(dataProvider = "getdata")
	public void flightSearchTest(Hashtable<String, String> data) throws IOException {
		
		if(!TestUtil.isrunnable("FlightSearchTest", reader)) {
			throw new SkipException("Skipping the test as the Run mode is NO");
		}

		if (data.get("runmode").equalsIgnoreCase("N")) {

			throw new SkipException("Skipping the test as the Run mode is NO");
		}

		
		System.out.println(data.get("fromdate"));
		System.out.println(data.get("todate"));
		BaseTest.initConfig();
		HomePage hp = new HomePage();
		hp.verifyEquals(7, hp.noOfTabs());
		hp.goToFlights().searchFlight(data.get("fromsource"), data.get("todestination"));

	}

	@AfterMethod
	public void teardown() {

		if (BaseTest.driver != null) {
			BaseTest.tearDown();
		}
	}

	@DataProvider
	public Object[][] getdata() {

		String sheetName = "FlightSearchTest";

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
