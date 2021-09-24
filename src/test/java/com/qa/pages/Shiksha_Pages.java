package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shiksha_Pages {
	
	
WebDriver driver;


public Shiksha_Pages(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(linkText = "Shiksha")
WebElement siksha;
@FindBy(xpath = "//*[@id=\"_globalNav\"]/div[2]/div[2]/a/div")
WebElement searchlogo;
@FindBy(xpath   = "//*[@id=\"searchInput\"]")
WebElement trendingColleges;
@FindBy(xpath = "//*[@id=\"chck-city-278\"]")
WebElement checkBox;
@FindBy(xpath = "//*[@id=\"chck-fees-f3\"]")
WebElement checkbox2;
@FindBy(xpath = "//*[@id=\"tabIndex2\"]")
WebElement searchtab;

public WebElement getSiksha() {
	return siksha;
}
public WebElement getSearchlogo() {
	return searchlogo;
}
public WebElement getTrendingColleges() {
	return trendingColleges;
}
public WebElement getCheckBox() {
	return checkBox;
}
public WebElement getCheckbox2() {
	return checkbox2;
}
public WebElement getSearchtab() {
	return searchtab;
}

}