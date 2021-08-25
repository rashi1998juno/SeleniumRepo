package com.qa.testscript;

import java.io.IOException;

//import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_003 extends TestBase {
	
	
	
	
	@Test
	public void newRegistration() throws IOException, Exception
	
	{
		WebElement ele=AmazonOR.getAccountdantList();
		Actions act=new Actions(driver);
		
		act.moveToElement(ele).build().perform();//enable drop down list
		Thread.sleep(3000);
		AmazonOR.getStarthereLink().click();
		String title=driver.getTitle();
		
		if(title.contains("Registration"))
		{
			Reporter.log(title,true);
			Reporter.log("Test is passed",true);
			Assert.assertTrue(true);
		}
		else
		{
			capturescreenShot(driver,"newRegistration");
			Reporter.log("Test is failed",true);
			Assert.assertTrue(false);
		}
		
		
		
		
	}

}
