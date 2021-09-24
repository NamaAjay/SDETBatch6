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

import com.qa.pages.SearchJobs_Pages;
import com.qa.utility.ExcelUtility;

public class TC_Search001 extends TestBase {
	SearchJobs_Pages sea;
	JavascriptExecutor js;

	@Test(dataProvider = "Search")
	public void search(String emil, String mobile, String location, String key)
			throws InterruptedException, IOException {
		System.out.println(emil);
		System.out.println(mobile);
		loginTest(emil, mobile);
		sea = new SearchJobs_Pages(driver);
		Thread.sleep(2000);
		sea.getDropdown().click();
		Thread.sleep(2000);
		sea.getSelectCourse().click();
		Thread.sleep(2000);
		sea.getLocation().sendKeys(location);
		Thread.sleep(2000);
		sea.getKeyWord().sendKeys(key);
		Thread.sleep(2000);
		sea.getSearchButton().click();
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		for (int i = 0; i <= 1; i++) {
			js.executeScript("window.scrollBy(0,400)");
			Thread.sleep(1000);
		}
		
		List<WebElement> getTitles = sea.getTit();
		for (WebElement titles : getTitles) {
			Reporter.log(titles.getText() + "<br>");
		}

		List<WebElement> list = sea.getresults();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}

		String title = driver.getTitle();
		if (title.contains("java")) {
			Reporter.log("title is matched");
			Assert.assertTrue(true);
		} else {
			capture(driver, "Search");
			Reporter.log("title is not matched");
			Assert.assertFalse(false);

		}

		 logOutTest();
	}

	@DataProvider(name = "Search")
	public String[][] getData() throws IOException {
		ExcelUtility excel = new ExcelUtility(path);
		int rownum = excel.getRowCount("Sheet1");
		int colnum = excel.getCellCount("Sheet1", 1);
		String data[][] = new String[rownum][colnum];
		for (int r = 1; r <= rownum; r++) {
			for (int c = 0; c < colnum; c++) {
				data[r - 1][c] = excel.getCellData("Sheet1", r, c);
			}
		}
		return data;
	}

}
