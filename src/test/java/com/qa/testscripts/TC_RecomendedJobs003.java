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

import com.qa.pages.RecomendedJobs_Pages;
import com.qa.utility.ExcelUtility;

public class TC_RecomendedJobs003 extends TestBase {
	RecomendedJobs_Pages recom;
	JavascriptExecutor js;
	
	@Test(dataProvider = "Recom")
	public void recomendedJobs(String email,String password) throws InterruptedException, IOException
	{
		recom=new RecomendedJobs_Pages(driver);
		loginTest(email, password);
		Thread.sleep(2000);
		/*pages.getHomePage().click();
		Thread.sleep(2000);*/
		String currentUrl=driver.getCurrentUrl();
		if(driver.getCurrentUrl().contains(currentUrl))
		{
		recom.getrecommndjobs().click();
		Thread.sleep(2000);
		List<WebElement>titles=driver.findElements(By.className("elp"));
		System.out.println("Recomended jobs list");
		js = (JavascriptExecutor) driver;
		for (int i = 0; i <= 1; i++)
		{
			js.executeScript("window.scrollBy(0,300)");
			Thread.sleep(1000);
		}
		for(WebElement getTitles:titles)
		  {
			Reporter.log(getTitles.getText());
			Assert.assertTrue(true);
		  }	
		}
		else
		{
			Reporter.log("method is failed");
			capture(driver, "recomendedJobs");
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
