package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.pages.TermsAndConditions_Pages;

public class TC_TermsAndConditions004 extends TestBase{
	TermsAndConditions_Pages terms;
	
	@Test
	public void terms() throws InterruptedException
	{
		terms=new TermsAndConditions_Pages(driver);
		js = (JavascriptExecutor) driver;
		for (int i = 0; i <= 2; i++) 
		{
			js.executeScript("window.scrollBy(0,300)");
			Thread.sleep(1000);
		}
		terms.getTermsAndConditions().click();
		js = (JavascriptExecutor) driver;
		for (int i = 0; i <= 2; i++) 
		{
			js.executeScript("window.scrollBy(0,300)");
			Thread.sleep(1000);
		}
		List<WebElement> termsTitles=driver.findElements(By.className("font16 orgtxt"));
				for(WebElement titles:termsTitles)
				{
					Reporter.log(titles.getText()+"<br>");
				}
				
		List<WebElement>conditions=driver.findElements(By.xpath("/html/body/div[4]/strong[8]"));
		for(WebElement conTitles:conditions)
		{
			Reporter.log(conTitles.getText()+"<br>");
		}
			
		
	}
	
}
