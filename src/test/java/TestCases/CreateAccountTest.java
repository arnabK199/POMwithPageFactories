package TestCases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePage.BaseTest;
import Pages.CreateAccountPage;
import Utilities.ExcelReader;
import Utilities.TestUtil;

public class CreateAccountTest{

	
	public static ExcelReader reader = null;

	@Test(dataProvider = "getdata")
	public void createAccountTest(Hashtable<String, String> data) throws InterruptedException {
		
		if (!TestUtil.isrunnable("CreateAccountTest", reader)) {

			throw new SkipException("Skipping the test as the Run mode is NO");
		}
		

		if (data.get("runmode").equalsIgnoreCase("N")) {

			throw new SkipException("Skipping the test as the Run mode is NO");
		}
		
		
		BaseTest.initConfig();
		Thread.sleep(2000);
		CreateAccountPage cap = BaseTest.topnav.gotoCreateAccountOption();
		Thread.sleep(2000);
		cap.createAccount(data.get("fname"), data.get("lname"), data.get("email"), data.get("password"));
		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardown() {
		
		if(BaseTest.driver!=null) {
		BaseTest.tearDown();
	}
	}
	
	
	@DataProvider
	public Object[][] getdata() {
		
		String sheetName = "CreateAccountTest";
		
		
		reader =BaseTest.getreader();
		
		int rowNum = reader.getRowCount(sheetName);
		int colNum = reader.getColumnCount(sheetName);
		
		Object[][] data = new Object[rowNum-1][1];
		
		Hashtable<String,String> table= null;
		
		for(int row = 2 ; row<=rowNum ; row++) {
			table = new Hashtable<String,String>();
			for(int col = 0 ; col< colNum ; col++) {
				table.put(reader.getCellData(sheetName, col, 1), reader.getCellData(sheetName, col, row));
				data[row-2][0] = table;
			}
			
			
		}
		
		return data;
	}

}
