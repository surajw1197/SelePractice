package m2;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AssertionDemo {
  @Test
  public void testMethod1() {
	  Assert.assertTrue(20>10);
  }
  @Test
  public void testMethod2() {
	  Assert.assertTrue("Hello".equals("hi"));
  }
  @Test
  public void testMethod3() {
	  Assert.assertFalse(20>18);
  }
  @Test
  public void testMethod4() {
	  Assert.assertFalse("Hello".equals("hi"));
  }
  @Test
  public void testMethod5() {
	  int actual =20;
	  int expected =20;
	  Assert.assertEquals(actual, expected);
  }
  @Test
  public void testMethod6() {
	  String actual="Hello";
	  String expected="hello";
	  Assert.assertEquals(actual, expected);
  }
  @Test
  public void testMethod7() {
	 Object obj1=null;
	 Assert.assertNull(obj1);
  }
  @Test
  public void testMethod8() {
	  Object obj1=new Object();
	  Object obj2=obj1;
	  Assert.assertSame(obj1, obj2);
  }
  @Test
  public void testMethod9() {
	Assert.fail("Intentionally Failing test");
  }
}
