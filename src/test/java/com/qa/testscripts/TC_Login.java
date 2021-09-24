package com.qa.testscripts;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.Login_Pages;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TC_Login extends TestBase
{
	// WebDriver driver;
	Login_Pages pages;
	JavascriptExecutor js;
	public WebDriverWait wait;
	private By bySubmit = By.id("loginSubmitBtn");
	private By byError = By.className("login_err");
	
	@Test(dataProvider="empLogin")
	public void VerifyInvalidLogin(String userName, String password) {
		pages=new Login_Pages(driver);
		
		pages.getEmail().sendKeys(userName);
		pages.getPassWord().sendKeys(password);
		//wait for element to be visible and perform click
		wait.until(ExpectedConditions.visibilityOfElementLocated(bySubmit));
		driver.findElement(bySubmit).click();
		
		//Check for error message
		wait.until(ExpectedConditions.presenceOfElementLocated(byError));
		String actualErrorDisplayed = driver.findElement(byError).getText();
		String requiredErrorMessage = "Please correct the marked field(s) below.";
		Assert.assertEquals(requiredErrorMessage, actualErrorDisplayed);
		
	}
	
	@DataProvider(name="empLogin")
	public Object[][] loginData() {
		Object[][] arrayObject = getExcelData(path,"Sheet4");
		return arrayObject;
	}
	
	
	
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows-1][totalNoOfCols];
			
			for (int i= 1 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//capture(driver, "loginTest");
		//Assert.assertTrue(true);
		//Thread.sleep(2000);
		//Reporter.log("login sucessfully");
		/*pages.getHomePage().click();
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		for (int i = 0; i <= 1; i++) {
			js.executeScript("window.scrollBy(500,0)");
			Thread.sleep(1000);
		}
		List<WebElement> getAlltitles = driver.findElements(By.className("mTxt"));

		for (WebElement titles : getAlltitles) {
			System.out.println(titles.getText());
			Reporter.log("<br>" + titles.getText() + "<br>");
		}
		for (int i = 0; i <= 1; i++) {
			js.executeScript("window.scrollBy(-500,0)");
			Thread.sleep(1000);
		}
		driver.findElement(By.tagName("img"));
		capture(driver, "logoTest");
		for (int i = 0; i <= 1; i++) {
			js.executeScript("window.scrollBy(500,0)");
			Thread.sleep(1000);
		}
	}

	@Test(priority = 2)
	public void logOut() throws InterruptedException, IOException {

		Thread.sleep(2000);
		pages.getProfile().click();
		Thread.sleep(2000);
		pages.getUserOption().click();
		Thread.sleep(2000);
		pages.getLogOutButton().click();
		Thread.sleep(2000);
		capture(driver, "logOut");
		Assert.assertTrue(true);
		Reporter.log("logout sucessfully");

	}
*/
	/*
	 * 
	/*
	 * @Test(priority = 3) public void applyJob() throws InterruptedException {
	 * 
	 * pages.getHomePage().click(); js=(JavascriptExecutor)driver; for(int
	 * i=0;i<=1;i++) { js.executeScript("window.scrollBy(-500,0)");
	 * Thread.sleep(1000); }
	 * 
	 * pages.getInternships().click(); Thread.sleep(2000);
	 * pages.getSearchBar().click(); Thread.sleep(1000);
	 * 
	 * pages.getDropDown2().click(); Thread.sleep(1000);
	 * driver.findElement(By.xpath("//*[@id=\"course\"]")).click();
	 * Thread.sleep(1000); pages.getSelectCourse2().click(); Thread.sleep(1000);
	 * pages.getLocation2().sendKeys("chennai"); Thread.sleep(1000);
	 * pages.getSkills().sendKeys("sql"); Thread.sleep(1000);
	 * pages.getSearchButton2().click(); Thread.sleep(4000);
	 * pages.getApply().click(); Thread.sleep(4000); Set<String> windowId =
	 * driver.getWindowHandles(); Iterator<String> iterator = windowId.iterator();
	 * 
	 * while (iterator.hasNext()) { String newWindowId = iterator.next();
	 * System.out.println(newWindowId); driver.switchTo().window(newWindowId);
	 * System.out.println(driver.getTitle()); if
	 * (driver.getTitle().contains("Human Resources")) {
	 * 
	 * driver.findElement(By.xpath("//*[@id=\"button_log_to_apply_up\"]")).click();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * } }
	 */
	/*
	 * @Test(priority = 3) public void termsAndConditions() throws
	 * InterruptedException, IOException
	 * 
	 * {
	 * 
	 * pages.getHomePage().click(); for (int i = 0; i <= 3; i++) {
	 * js.executeScript("window.scrollBy(0,500)"); Thread.sleep(1000); }
	 * driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/li[5]/a")).click();
	 * Thread.sleep(2000); capture(driver, "termsAndConditions");
	 * Assert.assertTrue(true);
	 * 
	 * 
	 * }
	 */
	
