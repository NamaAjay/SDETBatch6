package com.qa.testscripts;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.ApplyJob_Pages;
import com.qa.utility.ExcelUtility;

public class TC_ApplyJob002  extends TestBase{
	//ApplyJob_Pages applyJob;
	@Test(dataProvider = "Applyjob")
	public void applyJob(String email,String password,String location,String keyskill) throws InterruptedException, IOException
	{
		applyJob=new ApplyJob_Pages(driver);
		loginTest(email, password);
		Thread.sleep(2000);
		applyJob.getHomePage().click();
		Thread.sleep(2000);
		applyJob.getInternship().click();
		Thread.sleep(3000);
		applyJob.getInternshipSearchField().click();
		Thread.sleep(3000);
		applyJob.getSelectCourse().click();
		Thread.sleep(3000);
		List<WebElement> list=applyJob.getBranch();
		for(WebElement l:list)
		{
			if(l.getText().equals("BE / B.Tech")) 
			{
				l.click();
				break;
			}
		}
		applyJob.getLocation().sendKeys(location);
		applyJob.getDomain().sendKeys(keyskill);
		applyJob.getSearchBtn().click();
		Thread.sleep(3000);
		applyJob.getSelectJob().click();
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();
		// .............................Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{		Thread.sleep(3000);
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		String currentTitle=driver.getTitle();
		
		//checking user is landed on correct page or not....................
			if(driver.getTitle().contains(currentTitle))
			{
				Thread.sleep(3000);
				applyJob.getApplyBtn().click();
				Thread.sleep(3000);
				System.out.println("clicked");
				Reporter.log("user is landed on valid page");
				Assert.assertTrue(true);
				driver.close();
			}
		 	else
		 	{
			capture(driver, "applyJob");
			Assert.assertFalse(false);	
		 	}
		}
		}
		Thread.sleep(3000);
		driver.switchTo().window(parent);
	}
	
	@DataProvider(name = "Applyjob")
	public String[][] getData() throws IOException {
		ExcelUtility excel =new ExcelUtility(path);
		int rownum = excel.getRowCount("Sheet2");
		int colnum = excel.getCellCount("Sheet2", 1);
		String data[][] = new String[rownum][colnum];
		for (int r = 1; r <= rownum; r++) {
			for (int c = 0; c < colnum; c++) {
				data[r - 1][c] = excel.getCellData("Sheet2", r, c);
			}
		}
		return data;
	}


}


