package ddtDemos;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginMercuryDemo {
	
	WebDriver driver;
	
	
  @Test(dataProvider = "login")
  public void f(String username, String password) throws Exception {
	  System.out.println("username "+username);
	  driver.findElement(By.name("userName")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.name("login")).click();
	  
	  driver.findElement(By.linkText("SIGN-OFF")).click();
  }

  @DataProvider(name="login")
  public Object[][] getData() throws Exception {
    return MyExcelRead.ReadData();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");		
  }

  @AfterTest
  public void afterTest() {
	  //driver.close();
  }

}
