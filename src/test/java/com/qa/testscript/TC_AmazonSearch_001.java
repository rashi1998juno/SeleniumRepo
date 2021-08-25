package com.qa.testscript;

import java.io.IOException;

import java.util.List;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

//import com.qa.utility.ExcelUtility;

public class TC_AmazonSearch_001 extends TestBase {

	// validate the amazon application to search an item

	@Test(dataProvider = "getData")
	public void SearchItem(String Category, String Itemname) throws IOException
//	@Test
//	public void SearchItem() throws IOException
	{

		AmazonOR.getCategory().selectByVisibleText(Category);// 1st value
		// AmazonOR.getCategory().selectByVisibleText("Books");
		AmazonOR.getSearchTextbox().clear();
		// AmazonOR.getSearchTextbox().sendKeys("Da vini code");//2nd value
		AmazonOR.getSearchTextbox().sendKeys(Itemname);
		AmazonOR.getMagnifier_Enabled().click();

		String title = driver.getTitle();
//		if(title.contains(Itemname))
//		{
		if (title == Itemname) {
			Reporter.log("item is searched", true);// msg will be printed in html report also in the console
			Assert.assertTrue(true);
		} else {
			capturescreenShot(driver, "SearchItem");
			Reporter.log("item is not searched", true);// msg will be printed in html report also in the console
			Assert.assertTrue(false);

		}

		List<WebElement> itemNames = AmazonOR.get_Itemnames();
		for (WebElement item : itemNames) {
			Reporter.log(item.getText(), true);
		}

	}

	@DataProvider
	public String[][] getData() throws IOException {
		// Object[][] datas=new Object[3][2];

		String xFile = "C:\\Users\\HP\\Desktop\\Selenium_java\\MavenProject1.Selenium\\src\\test\\java\\com\\qa\\testdata\\InputData.xlsx";
		String xSheet = "Sheet1";
		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);

		String[][] datas = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				datas[i - 1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}

		return datas;

	}

}

//		//category list box
//		datas[0][0]="Books";
//		datas[1][0]="Electronics";
//		datas[2][0]="Furniture";
//		
//		//Item name field
//		datas[0][1]="Da vinci code";
//		datas[1][1]="Mobile phone";
//		datas[2][1]="Wooden Tables";
//		
//return datas;		
//		
//	}
//		
//	}
