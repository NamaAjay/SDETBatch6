package com.qa.utility;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting extends TestListenerAdapter{
	public ExtentHtmlReporter htmlReportrer;
	public ExtentReports exReports;
	public ExtentTest xTest;	 
	  public void onStart(ITestContext testContext) {
		  
		  String dateStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  String repName="Test_Report"+dateStamp+".htnl";
		  htmlReportrer=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+ repName);
		  
		  exReports=new ExtentReports();
		  exReports.attachReporter(htmlReportrer);
		  exReports.setSystemInfo("HostName", "loalhost");
		  exReports.setSystemInfo("QA", "Ajay");
		  htmlReportrer.config().setDocumentTitle("Test Automation");
		  htmlReportrer.config().setReportName("Functional Test report");
		  htmlReportrer.config().setAutoCreateRelativePathMedia(true);
		  
	  }

	  
	  public void onFinish(ITestContext testContext) {
		  exReports.flush();
	  }
	  
	  public void onTestSuccess(ITestResult tr) {
		 xTest= exReports.createTest(tr.getName());
		 xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		 xTest.log(Status.PASS, "Test Is Passed");
		 String SSName= System.getProperty("user.dir")+"/ScreenShot/"+tr.getName()+".png";
		    File file=new File(SSName);
		    if(file.exists())
		    {
		    	try
		    	{
		    		xTest.pass("Screen shot for test passed is"+ xTest.addScreenCaptureFromPath(SSName));
		    	}
		    	catch (Exception e) {
					e.printStackTrace();
				}
		    }
	  }

	  
	  public void onTestFailure(ITestResult tr) {
		 xTest= exReports.createTest(tr.getName());
		 xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		 xTest.log(Status.FAIL, "Test Is Passed");
		String SSName= System.getProperty("user.dir")+"/ScreenShot/"+tr.getName()+".png";
	    File file=new File(SSName);
	    if(file.exists())
	    {
	    	try
	    	{
	    		xTest.fail("Screen shot for test failed is"+ xTest.addScreenCaptureFromPath(SSName));
	    	}
	    	catch (Exception e) {
				e.printStackTrace();
			}
	    }
	  }

	 
	  public void onTestSkipped(ITestResult tr) {
		  xTest= exReports.createTest(tr.getName());
		  xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.BLUE));
			 xTest.log(Status.SKIP, "Test Is Passed");
	    
	  }


}
