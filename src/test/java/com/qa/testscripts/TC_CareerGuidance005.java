package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.qa.pages.CareerGuidance_Pages;

public class TC_CareerGuidance005 extends TestBase {
	CareerGuidance_Pages careerGuidanceOR;
	JavascriptExecutor js;
	@Test
	public void findHR_InterviewQA() throws InterruptedException
	{
		careerGuidanceOR=new CareerGuidance_Pages(driver);
		Thread.sleep(1000);
		
		careerGuidanceOR.getCarGuid().click();
		Thread.sleep(1000);
		careerGuidanceOR.getHR_Int_QA().click();
		Thread.sleep(1000);
		
		List<WebElement> readMore=careerGuidanceOR.getReadMore();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(int i=0;i<readMore.size();i++)
		{
			readMore.get(i).click();
			for(int j=0;j<=5;j++)
			{
				js.executeScript("window.scrollBy(0,200)");
				Thread.sleep(100);
			}
			for(int j=0;j<=5;j++)
			{
				js.executeScript("window.scrollBy(0,-200)");
				Thread.sleep(100);
			}
				driver.navigate().back();
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,100)");
				Thread.sleep(100);
		}

	}
}
