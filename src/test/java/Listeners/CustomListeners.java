package Listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import BasePage.BaseTest;
import Utilities.TestUtil;

public class CustomListeners extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
	
		//test = report.startTest(result.getName().toUpperCase());
		
		test = report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
	//	test.log(LogStatus.PASS, result.getName()+"passed");
	//	report.endTest(test);
	//	report.flush();
		
		
		String methodName = result.getMethod().getMethodName();

		String text = "<br>" + "TEST CASE: - " + methodName + "  PASSED";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);

		test.log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		try {
			TestUtil.CaptureScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	//	test.log(LogStatus.FAIL, result.getName()+"Failed with Exception :" +result.getThrowable());
		test.log(Status.FAIL, result.getName()+"Failed with Exception :" +result.getThrowable());
		
		//test.log(LogStatus.FAIL, test.addScreenCapture(System.getProperty("user.dir")+"\\src\\test\\resources\\TestScreenShots"+TestUtil.SSname));
		//--------------------------------------------------------------------------------------
		
		test.log(Status.FAIL , "<a target=\"_blank\" href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\TestScreenShots"+TestUtil.SSname+"\">ScreenShot</a>");
		test.log(Status.FAIL , "<a target = \"_blank\" href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\TestScreenShots"+TestUtil.SSname+"\"><img src =\""+System.getProperty("user.dir")+"\\src\\test\\resources\\TestScreenShots"+TestUtil.SSname+"\" height=150 width=120></img></a>");
		
		
		String ExceptionMsg = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" + ExceptionMsg.replaceAll(",", "<br>") + "</details>"
				+ " \n");
		
		
		String methodName = result.getMethod().getMethodName();

		String text = "<br>" + "TEST CASE: - " + methodName + "  FAILED";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.RED);

		test.log(Status.FAIL, m);
		 
		//-------------------------------------------------------------------------------------------------------------------
		
		Reporter.log("TestCases has failed with Error "+result.getThrowable());
		Reporter.log("Click on the link to view the ScreenShot");
		Reporter.log("<a target=\"_blank\" href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\TestScreenShots"+TestUtil.SSname+"\">ScreenShot</a>");
		Reporter.log("<br>");	
		Reporter.log("<br>");
		Reporter.log("<a target = \"_blank\" href=\""+System.getProperty("user.dir")+"\\src\\test\\resources\\TestScreenShots"+TestUtil.SSname+"\"><img src =\""+System.getProperty("user.dir")+"\\src\\test\\resources\\TestScreenShots"+TestUtil.SSname+"\" height=150 width=120></img></a>");
		
		//report.endTest(test);
		report.flush();
	}

	public void onTestSkipped(ITestResult result) {


		//test.log(LogStatus.SKIP, result.getName()+"has been Skipped as Runmode was No");
		//report.endTest(test);
		//report.flush();
		
		String methodName = result.getMethod().getMethodName();

		String text = "<br>" + "TEST CASE: - " + methodName + "  SKIPPED";
		Markup m = MarkupHelper.createLabel(text, ExtentColor.LIME);

		test.log(Status.SKIP, m);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}	

}
