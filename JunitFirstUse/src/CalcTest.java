import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;

public class CalcTest 
{
	 Calc tester;
	
      @Before
      public void Setup()
      {
    	  tester = new Calc();
      }
      
	  @Test
	  public void multiplicationOfZeroIntegersShouldReturnZero() 
	  {
	    assertEquals(0, tester.multiply(10, 0));
	    assertEquals(0, tester.multiply(0, 10));
	    assertEquals(0, tester.multiply(0, 0));
	  }
	  
	  @Test
	  public void dividingByZeroShouldSayInfinty() 
	  {
		  assertEquals("Infinty", tester.divide(10, 0));
	  }
	  
	  @Test
	  public void dividingByZeroWithZeroShouldBeZero() 
	  {
		  assertEquals("0", tester.divide(0, 0));
	  }
}
