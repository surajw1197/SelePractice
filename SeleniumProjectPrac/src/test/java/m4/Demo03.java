package m4;

import org.testng.annotations.Test;

import com.drivers.DriverUtility;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class Demo03 {
	WebDriver driver;
	@Test
	public void Login() {
		driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password456");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertEquals("Admin Home", driver.getTitle());
		Assert.assertTrue(driver.getPageSource().contains("Hi, Admin"));
		driver.findElement(By.xpath("//button[contains(.,'Add Category')]")).click();
		driver.findElement(By.xpath("//input[@id='catgName']")).sendKeys("Joote");
		driver.findElement(By.xpath("//input[@id='catgDesc']")).sendKeys("Joote");
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		
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
