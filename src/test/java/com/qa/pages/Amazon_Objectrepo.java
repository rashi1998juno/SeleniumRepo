package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Objectrepo {
	
	
	WebDriver driver;
	
	
	
	
	@FindBy(linkText="Start here.")
	WebElement StarthereLink;//reference variable which is going to store the value
	
	public WebElement getStarthereLink()
	{
		return StarthereLink;
	}
	
	

	@FindBy(id="nav-link-accountList")
	WebElement AccountdantList;//reference variable which is going to store the value
	
	public WebElement getAccountdantList()
	{
		return AccountdantList;
	}
	

	//category dropdown list
	
		@FindBy(id="searchDropdownBox")
		WebElement category;//reference variable which is going to store the value
		
		public Select getCategory()
		{
			Select cat=new Select(category);
			return cat;
		}
			
		//search text box
		
		
		@FindBy(id="twotabsearchtextbox")
		WebElement Search_Textbox;
		
		
		
		public WebElement getSearchTextbox()
		{
			return Search_Textbox;
		}
	
		
		//magnifier button
		
		
		
		@FindBy(id="nav-search-submit-button")
		WebElement Magnifier_button;
		
	
		public WebElement getMagnifier_Enabled()
		{
			return Magnifier_button;
		}
		
		
		
		
		@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
		List<WebElement> ItemsNames;
		
		public List<WebElement> get_Itemnames()
		{
			return ItemsNames;
		}
		
		
		@FindBy(id="nav-link-accountList-nav-line-1")
		WebElement accountlink;
		
		public WebElement get_Accountlink()
		{
			return accountlink;
		}
		
		
		@FindBy(linkText = "Start here.")
		WebElement RegLink;
		
		public WebElement get_Reglink()
		{
			return RegLink;
			
		}
		
		
		
		
		
		
		
		
		 public Amazon_Objectrepo(WebDriver driver) 
			{
			this.driver=driver;
			PageFactory.initElements(driver, this);//all the elements of this particular driver is attached
		}
		


	}
	
