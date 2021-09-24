package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class Login_Pages {
	WebDriver driver;
	@FindBy(xpath  = "/html/body/div[1]/div/div/ul[1]/li[7]/a")
	WebElement loginButton;
	
	  @FindBy(xpath ="//*[@id=\"loginEmail\"]")
	  WebElement email; 
	 
	  
	  @FindBy(xpath =   "//*[@id=\"loginPassword\"]") 
	  WebElement passWord;
	  
	  @FindBy(xpath  = "//*[@id=\"loginSubmitBtn\"]") 
	  WebElement submitButton;
	 
	  
	  @FindBy(xpath = "//*[@id=\"yellow_band\"]/a[1]") 
	  WebElement homePage;
	  
	  
	  public WebElement getLoginButton() {
		return loginButton;
	}


	public WebElement getEmail() {
		return email;
	}


	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	
	public WebElement getHomePage() {
		return homePage;
	}

//	@FindBy(xpath="//*[@id=\"loginForm\"]/fieldset/div[1]")
//	
//	WebElement errormsg;


	public Login_Pages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/span[1]")
	WebElement internships;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/form/div/input")
	WebElement searchBar;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/form/div[1]/div/span")
	WebElement dropDown2;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/form/div[1]/div/div/div/div/div/div/div[1]/ul/li[2]")
	WebElement selectCourse2;
	
	@FindBy(xpath = "//*[@id=\"location-sugg\"]")
	WebElement location2;
	
	@FindBy(xpath = "//*[@id=\"keyword-sugg\"]")
	WebElement skills;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/form/button")
	WebElement searchButton2;


	public WebElement getInternships() {
		return internships;
	}


	public WebElement getSearchBar() {
		return searchBar;
	}


	public WebElement getDropDown2() {
		return dropDown2;
	}


	public WebElement getSelectCourse2() {
		return selectCourse2;
	}


	public WebElement getLocation2() {
		return location2;
	}


	public WebElement getSkills() {
		return skills;
	}


	public WebElement getSearchButton2() {
		return searchButton2;
	}
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div/div[1]/a/span[1]/span")
	WebElement apply;


	public WebElement getApply() {
		return apply;
	}


	
	


	
	
	 	 
}
