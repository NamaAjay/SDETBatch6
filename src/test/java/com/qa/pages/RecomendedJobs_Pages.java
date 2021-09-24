package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecomendedJobs_Pages {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"mnjlftcol\"]/div[1]/div/div[2]/a")
	  WebElement recomendejobs;
	
	
	@FindBy(xpath = "//*[@id=\"profileImg\"]") 
	WebElement profile;
	public WebElement getProfile() {
		return profile;
	}
	
	public WebElement getrecommndjobs() {
		return  recomendejobs;
    
		
	}
	public RecomendedJobs_Pages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


}
