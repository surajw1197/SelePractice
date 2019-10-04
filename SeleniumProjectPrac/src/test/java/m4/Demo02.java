package m4;

import org.testng.annotations.Test;
import com.drivers.DriverUtility;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class Demo02 {
	WebDriver driver;
	@Test
	public void f() {
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		Assert.assertEquals("Login", driver.getTitle());
		List <WebElement> links = driver.findElements(By.tagName("a"));
		int no_links =links.size();
		System.out.println("No of links : "+no_links);
		for(WebElement s:links){  
			 System.out.println(s.getAttribute("href"));
		}  
	}
	@BeforeTest
	public void beforeTest() {
		driver = DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();
		
	}

	@AfterTest
	public void afterTest() {
		  driver.close();
	}

}
