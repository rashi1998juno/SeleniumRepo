/*
 * package com.qa.testscript;
 * 
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver;
 * 
 * import com.qa.pages.Amazon_Pages;
 * 
 * public class Amazon_Searchitem {
 * 
 * public static void main(String[] args) { 1.we are creating object reppository
 * for storing the webelents of Amazon Page 2.We name the object repository as
 * "Amazon_Pages" 3.In this class/or we need to create and store test object
 * description for each one the element 4.Allocating some memory where the
 * description can be stored into a variable 5.this refenc varble shuld hav
 * potential to store the test obj desc which comes in the form of locator
 * 6.Webdriver API has list of locators that is already configured:HTML
 * id,classname,linktext,partial linktext,tagname. xpath,css selector Define
 * syntax to store a this value of locator into a reference variable of type
 * webelement POM:Page Object Model is design pattern which has collection of
 * annotation/metadata tags that are available to create and store the
 * description... Need to follow the syntax syntax to store the
 * description/locator into variable
 * 
 * 
 * System.setProperty("webdriver.chrome.driver",
 * "C:\\Users\\HP\\Videos\\selenium_jar\\chromedriver.exe"); WebDriver driver =
 * new ChromeDriver();
 * 
 * 
 * Amazon_Pages amazon_or=new Amazon_Pages(driver);
 * driver.get("https://www.amazon.in/"); driver.manage().window().maximize();
 * System.out.println(amazon_or.getcategory_Selectstatus());
 * amazon_or.setCategory("Books");
 * 
 * System.out.println(amazon_or.getSearch_Textboxdisplayed());
 * amazon_or.setSearch_Textbox("Da vinci code");
 * 
 * 
 * System.out.println(amazon_or.getMagnifier_Enabled());
 * amazon_or.set_Magnifieraction();
 * 
 * System.out.println(driver.getTitle());
 * 
 * driver.getTitle();
 * 
 * 
 * }
 * 
 * }
 */