package extentReport;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ExtentReportTest {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	  

  @AfterMethod
  public void getResult(ITestResult result) throws IOException {
	  if(result.getStatus() == ITestResult.FAILURE) {
		  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + "-Test case Failed",ExtentColor.RED));
		  TakesScreenshot snapshot=(TakesScreenshot)driver;
		  File src = snapshot.getScreenshotAs(OutputType.FILE);
		  String path = System.getProperty("user.dir")+"/extent-reports/snapshots/"+result.getName()+".png";
		  FileUtils.copyFile(src,new File(path));
		  logger.addScreenCaptureFromPath(path,result.getName());
		  logger.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + "-Test case Failed",ExtentColor.RED));
	  }
	  else if(result.getStatus() == ITestResult.SKIP) {
		  logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName()+"-Test case Skipped",ExtentColor.ORANGE));
	  }
	  
	  
  }
/*
  @BeforeTest
  public void beforeTest() {
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/"+new SimpleDateFormat
					  ("hh-mm-ss-ms-dd-MM-yyyy").format(new Date())+".html");
	  //extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  extent.setSystemInfo("Host Name","GFT NexGen Testing Stream");
	  extent.setSystemInfo("Environment","Automation testing-Selenium");
	  extent.setSystemInfo("User Name","Somesh Reddewar");
	  
	  htmlReporter.config().setDocumentTitle("Title of documnet comes here ");
	  htmlReporter.config().setReportName("Name of Reporter comes here");
	  htmlReporter.config().setTheme(Theme.STANDARD);
  }
 */
  
  @Test
  public void failTestDemoWebShop() {
	  //extent = new ExtentReports();
	  
	  extent = new ExtentReports();
	logger = extent.createTest("failTest");
	System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	driver.findElement(By.id("userName")).sendKeys("Lalitha");
	driver.findElement(By.id("password")).sendKeys("Password12");
	driver.findElement(By.name("Login")).click();
	Assert.assertTrue(driver.findElement(By.partialLinkText("SignOut")).isDisplayed());
	driver.findElement(By.partialLinkText("SignOut")).click();
	}

  
/*  
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
  
  
@AfterTest
  public void endReport() {
	extent.flush();
  }*/
}
