package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TermsAndConditions_Pages {
	public WebElement getTermsAndConditions() {
		return termsAndConditions;
	}

	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[3]/div[3]/ul/li[5]/a")
	WebElement termsAndConditions;
	public TermsAndConditions_Pages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}
