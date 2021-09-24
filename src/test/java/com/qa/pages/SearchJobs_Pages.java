package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchJobs_Pages {
	WebDriver driver;
	public SearchJobs_Pages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@id=\"profileImg\"]") 
	WebElement profile;
	public WebElement getProfile() {
		return profile;
	}
		
		@FindBy(xpath = "//*[@id=\"spanid_qf\"]")
		WebElement dropdown;
		
		@FindBy(xpath = "//*[@id=\"eo\"]/optgroup[1]/option[10]")
		WebElement selectCourse;
		
		@FindBy(xpath = "//*[@id=\"ql\"]")
		WebElement location;
		
		@FindBy(xpath = "//*[@id=\"qp\"]")
		WebElement keyWord;
		
		@FindBy(xpath = "/html/body/div[6]/div/form/div/input")
		WebElement searchButton;
		
		@FindAll(@FindBy(xpath="//div//span[@class='elp jhead']//span[@class='elp']"))
		List<WebElement> results;
		public List<WebElement> getresults()
		{
			return results ;
		}

		
		public WebElement getDropdown() {
			return dropdown;
		}


		public WebElement getSelectCourse() {
			return selectCourse;
		}


		public WebElement getLocation() {
			return location;
		}


		public WebElement getKeyWord() {
			return keyWord;
		}


		public WebElement getSearchButton() {
			return searchButton;
		}
		
		@FindBy(className = "elp")
		List<WebElement> Tit;
		public List<WebElement> getTit() {
			return Tit;
		}


		
		
}
