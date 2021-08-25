package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports xReports;
	public static ExtentTest xTest;

	// public static WebDriver driver;
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String RepName = "Test-Execution-report" + timeStamp + ".html";
		String dest = System.getProperty("user.dir") + "/Reports/" + RepName;
		htmlReporter = new ExtentHtmlReporter(dest);
		htmlReporter.config().setDocumentTitle("Test Automation Report");
		htmlReporter.config().setReportName("Amazon Functional Testing");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);

		xReports = new ExtentReports();

		xReports.attachReporter(htmlReporter);// it will attach the testcases in the report
		xReports.setSystemInfo("HostName", "localhost");
		xReports.setSystemInfo("OS", "WINDOWS");
		xReports.setSystemInfo("Browser", "Chrome");

	}

	public void onFinish(ITestContext testContext) {
		xReports.flush();
	}

	public void onTestSuccess(ITestResult tr)

	{

		xTest = xReports.createTest(tr.getName());
		xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		xTest.log(Status.PASS, "Test is passed");

	}

	public void onTestFailure(ITestResult tr) {

		xTest = xReports.createTest(tr.getName());
		xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		xTest.log(Status.FAIL, "Test is failed");
		xTest.log(Status.FAIL, tr.getThrowable());
		
		String Path=System.getProperty("user.dir")+"/Screenshots/"+ tr.getName()+".png";
		File file=new File(Path);
		
		if(file.exists())
		{
			try {
				xTest.fail("Screen shot for the test failed is : " + xTest.addScreenCaptureFromPath(Path) );
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
	}

	public void onTestSkipped(ITestResult tr) {

		xTest = xReports.createTest(tr.getName());
		xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		xTest.log(Status.SKIP, "Test is skipped");
		xTest.log(Status.SKIP, tr.getThrowable());

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
