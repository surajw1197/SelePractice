package m5;

import org.testng.annotations.Test;

import com.drivers.DriverUtility;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DragAndDrop {
	WebDriver driver;
	@Test
	public void f() {	
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		WebElement from =driver.findElement(By.xpath("/html/body/form/div[4]/div[3]/div[1]/div[2]/div/div[1]/div/div/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement to =driver.findElement(By.xpath("/html/body/form/div[4]/div[3]/div[1]/div[2]/div/div[3]/div/div/table/tbody/tr/td"));
		Actions act1= new Actions(driver);
		
		act1.dragAndDrop(from, to).perform();
		
		act1.dragAndDrop(from, to).perform();
		
		
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
