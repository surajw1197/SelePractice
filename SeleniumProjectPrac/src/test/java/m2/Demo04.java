package m2;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class Demo04 {
	WebDriver driver;

	 @Test(dataProvider = "loginData")
	  public void loginTest(String username, String password) {
		
		  //System.out.println("username : "+username+" password:"+password);
		  driver.findElement(By.name("userName")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("login")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.linkText("SIGN-OFF")).click();
	  }

	  @DataProvider
	  public Object[][] loginData() {
	    return new Object[][] {
	      new Object[] { "mercury", "mercury" },
	      new Object[] { "mercury1", "mercury1" },
	    };
	  }
	  
	  @BeforeTest
		public void beforeTest() {
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			 driver.get("http://newtours.demoaut.com/");
		}
	  @AfterTest
		public void afterTest() {
			driver.close();
		}
}
