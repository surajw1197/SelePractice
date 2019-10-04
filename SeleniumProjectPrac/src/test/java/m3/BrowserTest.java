package m3;

import org.testng.annotations.Test;
import com.drivers.DriverUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BrowserTest {
	  
//	Web driver instance to connect to web browser
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://www.gmail.com");
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	 driver = DriverUtility.getDriver("chrome");
	 driver.manage().window().maximize();
	 Thread.sleep(3000);
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  

	

	
	
	
	


}
