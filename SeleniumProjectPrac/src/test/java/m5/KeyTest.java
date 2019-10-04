package m5;

import org.testng.annotations.Test;

import com.drivers.DriverUtility;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class KeyTest {
	WebDriver driver;
	@Test
	public void f() {
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement serach = driver.findElement(By.id("myInput"));
		Actions act1=new Actions(driver);
		act1.keyDown(serach,Keys.SHIFT).perform();
		act1.sendKeys("b").pause(1000).sendKeys("a").pause(1000).sendKeys("g").build().perform();
		act1.moveToElement(driver.findElement(By.xpath("(//div[contains(.,'Hand bag')])[4]"))).click().perform();
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//window switching 
		Set <String> winhandle=driver.getWindowHandles();
		for(String s:winhandle) {
			driver.switchTo().window(s);
		}
		
		String textget = driver.findElement(By.xpath("//h4[contains(text(),'Hand bag')]")).getText();
		System.out.println(textget);
		Assert.assertTrue(textget.contains("Hand bag"));
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
