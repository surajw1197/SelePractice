package m4;

import org.testng.annotations.Test;

import com.drivers.DriverUtility;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Demo04Navigation {
  WebDriver driver;
	@Test
  public void navigationFun() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		
		System.out.println("Page URL : "+driver.getCurrentUrl());
		System.out.println("Page TITLE : "+driver.getTitle());
		driver.navigate().to("https://portal.accenture.com");
		
		System.out.println("Page URL : "+driver.getCurrentUrl());
		System.out.println("Page TITLE : "+driver.getTitle());
		driver.navigate().to("http://demowebshop.tricentis.com/");
		driver.navigate().to("https://www.google.co.in/");
		driver.navigate().refresh();
		driver.close();
		
  }
  @BeforeTest
  public void beforeTest() {
	  driver = DriverUtility.getDriver("chrome");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
