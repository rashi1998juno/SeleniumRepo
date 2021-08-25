package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Pages {
	/*1.we are creating object reppository for storing the webelents of Amazon Page
	 * 2.We name the object repository as "Amazon_Pages"
	 * 3.In this class/or we need to create and store  test object description for each one the element
	 * 4.Allocating some memory where the description can be stored into a variable
	 * 5.this refenc varble shuld hav potential to store the test obj desc which comes in the form of locator
	 * 6.Webdriver API has list of locators that is already configured:HTML id,classname,linktext,partial linktext,tagname.
	 *xpath,css selector
	 *Define syntax to store a this value of locator into a reference variable of type webelement
	 *POM:Page Object Model is design pattern which has collection of annotation/metadata tags that are available
	 *to create and store the description...
	 *Need to follow the syntax
	 *syntax to store the description/locator into variable
	 */
	
	/*
	 *@Findby(locatorname="value)
	 *@Cachelookup
	 *Webelement variableName
	 */
	
	
	WebDriver driver;
	//category dropdown list
	
	@FindBy(id="searchDropdownBox")
	@CacheLookup
	WebElement category;//reference variable which is going to store the value
	
	
	
	public boolean getcategory_Selectstatus()
	{
		return category.isDisplayed();
	}
	
	
	public void setCategory(String cat_Name)
	{
		
		Select select_category= new Select(category);
		select_category.selectByVisibleText(cat_Name);
	}
	
	
	
	
	
	//search text box
	
	
	@FindBy(id="twotabsearchtextbox")
	@CacheLookup
	WebElement Search_Textbox;
	
	
	
	public boolean getSearch_Textboxdisplayed()
	{
		return Search_Textbox.isDisplayed();
	}
	
	
	public void setSearch_Textbox(String Item_Name)
	{
		Search_Textbox.sendKeys(Item_Name);
		
	}
	
	
	
	
	//magnifier button
	
	
	
	@FindBy(id="nav-search-submit-button")
	@CacheLookup
	WebElement Search_button;
	
	

	public boolean getMagnifier_Enabled()
	{
		return Search_button.isEnabled();
	}
	
	
	public void set_Magnifieraction()
	{
		Search_button.click();
		
	}
	
	
	public Amazon_Pages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	


}
