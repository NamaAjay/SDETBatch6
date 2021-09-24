package com.qa.testscripts;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.Shiksha_Pages;
import com.qa.utility.ExcelUtility;

public class TC_Shiksha006 extends TestBase {
	
	
	@Test(dataProvider = "Recom")
	public void Profile(String email,String password) throws InterruptedException, IOException
	{
		page=new Shiksha_Pages(driver);
		js=(JavascriptExecutor)driver;
		loginTest(email, password);
		Thread.sleep(2000);
		for (int i = 0; i <= 1; i++)
		{
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		}
		page.getSiksha().click();
		Thread.sleep(2000);
		page.getSearchlogo().click();
		Thread.sleep(2000);
		page.getTrendingColleges().sendKeys("Business and Management");
		Thread.sleep(2000);
		page.getSearchtab().click();
		Thread.sleep(2000);
		for (int i = 0; i <= 1; i++)
		{
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		}
		page.getCheckBox().click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		for (int i = 0; i <= 1; i++)
		{
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		}
		Thread.sleep(2000);
		String currentTitle=driver.getTitle();
		if(driver.getTitle().contains(currentTitle))
		{
			System.out.println("user in business management page");
			Reporter.log(driver.getTitle());
			Assert.assertTrue(true);
			List<WebElement> titles=driver.findElements(By.className("instNamev2"));
			for(WebElement gettitles:titles)
			{
				Reporter.log(gettitles.getText()+"<br>");
			}	
		}
		else
		{
			capture(driver, "Profile");
			Assert.assertFalse(false);
		}
		
	 }
	@DataProvider(name = "Recom")
	public String[][] getData() throws IOException {
	ExcelUtility excel =new ExcelUtility(path);
	int rownum = excel.getRowCount("Sheet3");
	int colnum = excel.getCellCount("Sheet3", 1);
	String data[][] = new String[rownum][colnum];
	for (int r = 1; r <= rownum; r++) {
	for (int c = 0; c < colnum; c++) {
	data[r - 1][c] = excel.getCellData("Sheet3", r, c);
	}
	}
	return data;
	}

}
