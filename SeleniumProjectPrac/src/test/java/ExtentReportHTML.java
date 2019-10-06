package extentReport;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class ExtentReportHTML {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	  
	


  
  
  
  @BeforeTest
  public void beforeTest() {
  
  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/"+new SimpleDateFormat("hh-mm-ss-dd-MM-yyyy").format(new java.util.Date())+".html");
extent = new ExtentReports();
extent.attachReporter(htmlReporter);
extent.setSystemInfo("Host Name","GFT NexGen Testing Stream");
extent.setSystemInfo("Environment","Automation testing-Selenium");
extent.setSystemInfo("User Name","Somesh Reddewar");

htmlReporter.config().setDocumentTitle("Title of documnet comes here ");
htmlReporter.config().setReportName("Name of Reporter comes here");
htmlReporter.config().setTheme(Theme.STANDARD);

  
  }
  

  @Test
  public void passTest() {


	
	logger = extent.createTest("passTest");
	Assert.assertTrue(true);
	logger.log(Status.PASS,MarkupHelper.createLabel("Test can passed is passTest",ExtentColor.GREEN));
	}
  
  @Test
  public void failTest() {


	  
	  logger = extent.createTest("failTest");
	  Assert.assertTrue(false);
	   }
  
  @Test
  public void skipTest() {
	  logger = extent.createTest("skipTest");
	  throw new SkipException("Skipping- This is not ready for testing");
  }
  @AfterMethod
  public void getResult(ITestResult result) throws IOException {
	  if(result.getStatus() == ITestResult.FAILURE) {
		  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + "-Test case Failed",ExtentColor.RED));
		  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + "-Test case Failed",ExtentColor.RED));
	  }
	  else if(result.getStatus() == ITestResult.SKIP) {
		  logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"-Test case Skipped",ExtentColor.ORANGE));
	  }
	  
	  
  }
  
  


@AfterTest
  public void endReport() {
	extent.flush();
  }
}
