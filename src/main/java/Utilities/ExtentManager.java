package Utilities;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports report;
	private static ExtentHtmlReporter htmlReporter;
	
	
/*	public static ExtentReports getInstance(){
		
		if(report==null){
			
			
			report = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			report.loadConfig(new File(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\extent-config.xml"));
			
		}
		
		return report;
		
	} */
	
	
	public static ExtentReports getLatestReport() {
		
		Date d = new Date();
		String filename = "Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
		
		htmlReporter = new ExtentHtmlReporter("./Reports/"+filename);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Arnab's Extent Report");
		htmlReporter.config().setDocumentTitle("My Extent Report");
		htmlReporter.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReporter);

		report.setSystemInfo("Automation Tester", "Arnab Kundu");
		report.setSystemInfo("Orgainzation", "Way2Automation");
		report.setSystemInfo("Build No", "W2A-1234");
		
		return report;
		
		
	}

}
