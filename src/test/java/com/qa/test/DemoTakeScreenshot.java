package com.qa.test;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.Amazon_Objectrepo;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class DemoTakeScreenshot {
	
	
	public WebDriver driver;
	
	//Amazon_Objectrepo AmazonOR;
		
		//1.Open a browser
	
	
	
	@BeforeClass
	public void setUp()
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Videos\\selenium_jar\\chromedriver_win32 (2)\\chromedriver.exe");
		driver =new ChromeDriver();
		//driver.execute_script("replace.window.location{"https://www.amazon.in/"}");
		driver.get("https://www.amazon.in/");
		}
	
	
	@AfterClass
	public void tearDown()
	{
		//close the browser
		driver.close();	
	}
	
	
	@Test(priority=1)
	public void screenshotofElement() throws IOException {
		File Source=driver.findElement(By.id("nav-logo-sprites")).getScreenshotAs(OutputType.FILE);
		String Dest=System.getProperty("user.dir")+"/Screenshots/"+"AmazonLogo.png";
		FileUtils.copyFile(Source, new File(Dest));
		
		
	}
	
	@Test(priority=2)
	public void screenshotOfDriver() throws IOException
	{
		TakesScreenshot screenShot=(TakesScreenshot) driver;
		File Source=screenShot.getScreenshotAs(OutputType.FILE);
		String Dest=System.getProperty("user.dir")+"/Screenshots/"+"AmazonPage.png";
		FileUtils.copyFile(Source, new File(Dest));
		
	}
	
	
	@Test(priority=3)
	public void screenshotOfFullPage() throws IOException
	{
		AShot SShot=new AShot();
		Screenshot Source=SShot.shootingStrategy(ShootingStrategies.viewportPasting(300)).takeScreenshot(driver);
		String Dest=System.getProperty("user.dir")+"/Screenshots/"+"AmazonFullPage.jpg";
		ImageIO.write(Source.getImage(), "jpg", new File(Dest));
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
