package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.ApplyJob_Pages;
import com.qa.pages.LogOut_Pages;
import com.qa.pages.Login_Pages;
import com.qa.pages.RecomendedJobs_Pages;
import com.qa.pages.SearchJobs_Pages;
import com.qa.pages.TermsAndConditions_Pages;
import com.qa.pages.Shiksha_Pages;
import com.qa.utility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static ApplyJob_Pages applyJob;
	public static Login_Pages pages;
	public static SearchJobs_Pages sea;
	public static LogOut_Pages logout;
	public static RecomendedJobs_Pages recom;
	public static TermsAndConditions_Pages terms;
	public static Shiksha_Pages page;
	public static String path;
	JavascriptExecutor js;
	
	@Parameters({"Browser", "url"})
	@org.testng.annotations.BeforeClass
	public void setUp(String Browser,String url)
	{
		if(Browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		applyJob = new ApplyJob_Pages(driver);
		driver.manage().window().maximize();
		driver.get(url);
		path= "C:\\Users\\cysve\\OneDrive\\Desktop\\NewWorkSpace\\AmazonProject\\TestAutomation\\src\\test\\java\\com\\qa\\testdata\\inputData.xlsx";
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public static void capture(WebDriver driver, String screenShotName) throws IOException, InterruptedException
	{
         TakesScreenshot ts=(TakesScreenshot)driver;
		
		//Taking the screenshot and stored in one source file............
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		//copy the screenshots into particular destination..................
		
		FileUtils.copyFile(source, new File("./ScreenShot/"+screenShotName+".png"));
		Thread.sleep(1000);
		System.out.println("ScreenShot has been taken");
	}
	
	//(dataProvider = "AddCustomer") 
	public void loginTest(String email,String password) throws InterruptedException, IOException 
	{	
		pages = new Login_Pages(driver);
		pages.getLoginButton().click();
		Thread.sleep(2000);
		pages.getEmail().sendKeys(email);
		
		Thread.sleep(2000);
		pages.getPassWord().sendKeys(password);
		
		Thread.sleep(2000);
		pages.getSubmitButton().click();
		Thread.sleep(2000);
	}

	/*
	 * @DataProvider(name = "AddCustomer") public String[][] getData() throws
	 * IOException { ExcelUtility excel =new ExcelUtility(path); int rownum =
	 * excel.getRowCount("Sheet1"); int colnum = excel.getCellCount("Sheet1", 1);
	 * String data[][] = new String[rownum][colnum]; for (int r = 1; r <= rownum;
	 * r++) { for (int c = 0; c < colnum; c++) { data[r - 1][c] =
	 * excel.getCellData("Sheet1", r, c); } } return data; }
	 */
	
	public void logOutTest() throws InterruptedException {
		logout = new LogOut_Pages(driver);
		logout.getProfile().click();
		Thread.sleep(2000);
		logout.getUserOption().click();
		Thread.sleep(2000);
		logout.getLogOutButton().click();
		Thread.sleep(2000);

	}
 
}
