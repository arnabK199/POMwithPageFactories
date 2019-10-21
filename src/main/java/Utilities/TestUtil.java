package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import BasePage.BaseTest;


public class TestUtil extends BaseTest {


	static Date d = new Date();
	public static String SSname;
	
	public static void CaptureScreenshot(String tcname) throws IOException {
	
		SSname =d.toString().replace(":", "_").replace(" ", "_") +"tcname"+".jpg";
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestScreenShots"+SSname));
	}
	
	public static void CaptureScreenshotForVerify() throws IOException {
		
		SSname =d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		 
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\src\\test\\resources\\VerifyTestScreenShots"+SSname));
	}

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = reader.getRowCount(sheetName);
		int cols = reader.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			
			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(reader.getCellData(sheetName, colNum, 1), reader.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	
	

	
public static boolean isrunnable(String testname, ExcelReader reader) {
		
		String tcname ="testsuite";
		int rows = reader.getRowCount(tcname);
		
		for(int rNum=2; rNum<=rows; rNum++) {
			String data = reader.getCellData(tcname, "TCID", rNum);
			if(data.equalsIgnoreCase(testname)) {
				String runmode = reader.getCellData(tcname, "runmode", rNum);
				if(runmode.equalsIgnoreCase("Y")) {
					return true;
				}
				else{
					return false;
				}
			}
			
		}
		return false;
	}
	
}
