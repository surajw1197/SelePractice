package m4;

import org.testng.annotations.Test;

import com.drivers.DriverUtility;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Demo05Select {
	WebDriver driver;
	@Test
	public void f() {
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.navigate().to("http://10.232.237.143:443/TestMeApp/login.htm");

		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password456");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//h4[contains(.,'View Product')]")).click();
		Select obj = new Select(driver.findElement(By.xpath("//select[@name='categorydropname']")));
		List <WebElement> options = obj.getOptions();

		for(WebElement s:options){  
			System.out.println(s.getText());
			// Assert.assertEquals(s.getText(),"Electronics");
			if(s.getText().equals("Electronics")) {
				obj.selectByVisibleText(s.getText());
				break;
			}

		}
		Select subobj = new Select(driver.findElement(By.xpath("//select[contains(@name,'subcategorydropname')]")));
		List <WebElement> suboptions = subobj.getOptions();

		for(WebElement sub:suboptions){  
			System.out.println(sub.getText());

			if(sub.getText().equals("Travel Kit")) {
				subobj.selectByVisibleText(sub.getText());
				break;
			}
		}
		
		driver.findElement(By.xpath("//select[@id='subcategorydropid']")).click();



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
