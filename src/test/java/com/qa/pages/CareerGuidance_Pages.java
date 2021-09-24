package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerGuidance_Pages {
	
	
	
	WebDriver driver;
	public CareerGuidance_Pages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="/html/body/div[1]/div/div/ul[1]/li[4]/a/div")
	@CacheLookup
	WebElement carGuid;
	public WebElement getCarGuid()
	{
		return carGuid;
	}
	
	@FindBy(xpath="//body/div[1]/div[1]/div[3]/a[1]")
	@CacheLookup
	WebElement HR_Int_QA;
	public WebElement getHR_Int_QA()
	{
		return HR_Int_QA;
	}

	@FindAll(@FindBy(xpath="//a[@class=\"more\"]"))
	List<WebElement> readMore;
	public List<WebElement> getReadMore()
	{
		return readMore;
	}

}
