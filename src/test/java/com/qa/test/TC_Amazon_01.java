//package com.qa.test;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.qa.utility.ExcelUtility;
//
//public class TC_Amazon_01 extends  {
//	
//	//validate the amazon application to search an item
//	
//	@Test(dataProvider="getData")
//	public void SearchItem(String Category,String Itemname)
//	{
//		
//		AmazonOR.getCategory().selectByVisibleText(Category);//1st value
//		AmazonOR.getSearchTextbox().clear();
//		AmazonOR.getSearchTextbox().sendKeys(Itemname);//2nd value
//		AmazonOR.getMagnifier_Enabled().click();
//		
//		String title=driver.getTitle();
//		if(title.contains(Itemname))
//		{
//			Reporter.log("item is searched", true);//msg will be printed in html report also in the console
//			Assert.assertTrue(true);
//		}
//		else
//		{
//			Reporter.log("item is not searched", false);//msg will be printed in html report also in the console
//			Assert.assertTrue(true);
//			
//		}
//		
//		
//		List<WebElement> itemNames= AmazonOR.get_Itemnames();
//		for(WebElement item:itemNames)
//		{
//			Reporter.log(item.getText(), true);
//		}	
//		
//	
//	}
//	
//	
//	
//	
//	@DataProvider
//	public String[][] getData() throws IOException
//	{
//		//Object[][] datas=new Object[3][2];
//		
//		
//		String xFile="C:\\Users\\HP\\Desktop\\Selenium_java\\MavenProject1.Selenium\\src\\test\\java\\com\\qa\\testdata\\InputData.xlsx";
//		String xSheet="Sheet1";
//		int rowCount=ExcelUtility.getRowCount(xFile, xSheet);
//		int cellCount=ExcelUtility.getCellCount(xFile, xSheet, rowCount);
//		
//		String[][]  datas=new String[rowCount][cellCount];
//		
//		
//		for(int i=1;i<=rowCount;i++)
//		{
//			for(int j=0;j<cellCount;j++)
//			{
//				datas[i-1][j]=ExcelUtility.getCellData(xFile, xSheet, i, j);
//			}
//		}
//		
//	
//	
//	
//	
//
//}
