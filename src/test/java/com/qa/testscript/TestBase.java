package com.qa.testscript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.pages.Amazon_Objectrepo;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	//write the code for test fixture
	
	//test fixture:common for all the test scripts/test case
	
	//test base can perform some pre and post condition

	WebDriver driver;
	Amazon_Objectrepo AmazonOR;
		
		//1.Open a browser
	
	
	@BeforeClass
	@Parameters("Url")
		public void setUp(String Url)
		{
		//1.Open a browser
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Videos\\selenium_jar\\chromedriver_win32 (2)\\chromedriver.exe");
		driver =new ChromeDriver();
	
		
		AmazonOR=new Amazon_Objectrepo(driver);
	    //2.launching the url
		driver.get(Url);
		
		}
	
	
	@AfterClass
	public void tearDown()
	{
		//close the browser
		driver.close();	
		
}
	
	
	public void capturescreenShot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot screenShot=(TakesScreenshot) driver;
		File Source=screenShot.getScreenshotAs(OutputType.FILE);
		String Dest=System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
		FileUtils.copyFile(Source, new File(Dest));
		
		
	}
	
}
