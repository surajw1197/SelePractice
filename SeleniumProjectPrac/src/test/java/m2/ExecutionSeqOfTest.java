package m2;

import org.testng.annotations.Test;

public class ExecutionSeqOfTest {
  @Test(priority=1)
  public void testGoogle() {
	  System.out.println("In testGoogle");
  }
  @Test(priority=2)
  public void testTwitter() {
	  System.out.println("In testTwitter");
  }
  @Test(priority=3,enabled=false)
  public void testFacebook() {
	  System.out.println("In testFacebook");
  }
  
}
