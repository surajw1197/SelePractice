package m5;

import org.testng.annotations.Test;

import com.drivers.DriverUtility;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class MouseTest {
	WebDriver driver;
	@Test
	public void f() {
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions act1= new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'AboutUs')]"))).
		moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Our\n" + 
				"												Offices')]"))).
		moveToElement(driver.findElement(By.xpath("//a[contains(.,'Chennai')]"))).click().build().perform();
		
		Set <String> winhand = driver.getWindowHandles();
		for(String str:winhand) {
			driver.switchTo().window(str);
		}
		Assert.assertTrue(driver.getCurrentUrl().contains("chn"));

	}
	@BeforeTest
	public void beforeTest() {
		driver = DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
