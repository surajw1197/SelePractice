package m2;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProvideDemo {
  @Test(dataProvider = "loginData")
  public void f(String username, String password) {
	  System.out.println("username : "+username+" password:"+password);
  }

  @DataProvider
  public Object[][] loginData() {
    return new Object[][] {
      new Object[] { "user1", "pass123" },
      new Object[] { "user2", "passw123" },
    };
  }
}
