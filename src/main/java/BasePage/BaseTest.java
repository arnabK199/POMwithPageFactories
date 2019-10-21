package BasePage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.relevantcodes.extentreports.LogStatus;

import Pages.TopNavigationPage;
import Utilities.ExcelReader;
import Utilities.ExtentManager;
import Utilities.TestUtil;


public class BaseTest {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	public static Logger logs = Logger.getLogger("devpinoyLogger");
	public static ExcelReader reader = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\PageFactoryTestData.xlsx");
	public static WebDriverWait wait;
	public ExtentReports report = ExtentManager.getLatestReport();
	public static ExtentTest test;
	
	public static TopNavigationPage topnav;
	
	
	
	public static void initConfig() {
		
		
		if (Constants.browser.equalsIgnoreCase("firefox")) {

			// System.setProperty("webdriver.gecko.driver", "gecko.exe");
			driver = new FirefoxDriver();

		} else if (Constants.browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
			driver = new ChromeDriver();
			

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			
			logs.debug("Chrome Launched !!!");
		} else if (Constants.browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.get(Constants.url);
		logs.debug("Navigated to : " + Constants.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait((Constants.impWait),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		topnav = new TopNavigationPage(driver);
		
	}
	
	
	public static void tearDown() {
		driver.quit();
		
}
	
	public static void click(WebElement element) {
		
		element.click();
		//test.log(LogStatus.INFO, "clicked on Element : "+element);
		test.log(Status.INFO, "clicked on Element : "+element);
		logs.info("clicked on Element : "+element);
	}
	
	
	public void type(WebElement element, String value) {
		
		element.sendKeys(value);
		//test.log(LogStatus.INFO, "Typed on Element : "+element+ " with value : " +value);
		test.log(Status.INFO, "Typed on Element : "+element+ " with value : " +value);
		logs.info("Typed on Element : "+element+ " with value : " +value);
	}
		
		
	
	public void verifyEquals(int i , int j) throws IOException {
		
		try {
			Assert.assertEquals(j, i);
			
		}catch(Throwable t){
			
			TestUtil.CaptureScreenshotForVerify();
			
			
		//	test.log(LogStatus.INFO, "Test Verification Failes with Exception : " + t.getMessage());
			test.log(Status.INFO, "Test Verification Failes with Exception : " + t.getMessage());
			
		//	test.log(LogStatus.INFO, test.addScreenCapture(System.getProperty("user.dir")+"\\src\\test\\resources\\VerifyTestScreenShots"+TestUtil.SSname));
			test.log(Status.INFO, (Markup) test.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\src\\test\\resources\\VerifyTestScreenShots"+TestUtil.SSname));
			
			
			Reporter.log("Test Verification Failes with Exception : " + t.getMessage());
			Reporter.log("<a target=\"_blank\" href =\""+System.getProperty("user.dir")+"\\src\\test\\resources\\VerifyTestScreenShots"+TestUtil.SSname+"\">ScreenShot</a> ");
			Reporter.log("<br>");	
			Reporter.log("<br>");
			Reporter.log("<a target = \"_blank\" href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\VerifyTestScreenShots"+TestUtil.SSname+"\"><img src =\""+System.getProperty("user.dir")+"\\src\\test\\resources\\VerifyTestScreenShots"+TestUtil.SSname+"\" height=150 width=120></img></a>");
			
			
		}
	}


	public static ExcelReader getreader() {
		// TODO Auto-generated method stub
		return reader;
	}

}
