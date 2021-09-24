package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut_Pages {
WebDriver driver;
@FindBy(xpath = "//*[@id=\"profileImg\"]") 
WebElement profile;

@FindBy(xpath = "//*[@id=\"userOptionArrow\"]") 
WebElement userOption;

@FindBy(xpath = "//*[@id=\"userOptionDiv\"]/a[2]") 
WebElement logOutButton;
public WebElement getProfile() {
	return profile;
}


public WebElement getUserOption() {
	return userOption;
}

public WebElement getLogOutButton() {
	return logOutButton;
}
public LogOut_Pages(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}




}
