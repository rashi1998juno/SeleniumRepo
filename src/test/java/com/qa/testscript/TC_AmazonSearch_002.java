package com.qa.testscript;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AmazonSearch_002 extends TestBase {
	
	//validate the amazon application for new user registration
	
	
	@Test
	public void newRegistration()
	{
		
		WebElement ele=AmazonOR.get_Accountlink();
		
		Actions act=new Actions(driver);
		act.moveToElement(ele).build().perform();//mouse hover on the account link
		
		
		AmazonOR.get_Reglink().click();
		
		String title=driver.getTitle();
		Assert.assertEquals(title, "Amazon Registration");
		
	}
	
}
