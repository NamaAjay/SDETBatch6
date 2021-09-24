package com.qa.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qa.pages.LogOut_Pages;

public class TC_LogOut extends TestBase {
	
LogOut_Pages logout;
JavascriptExecutor js;

@Test
public void logOutTest() throws InterruptedException
{
	logout=new LogOut_Pages(driver);
	js = (JavascriptExecutor) driver;
	for (int i = 0; i <= 2; i++)
	{
		js.executeScript("window.scrollBy(-300,0)");
		Thread.sleep(1000);
	}
	Thread.sleep(2000);
	logout.getUserOption().click();
	Thread.sleep(2000);
	logout.getLogOutButton().click();
	Thread.sleep(2000);
	
}


}
