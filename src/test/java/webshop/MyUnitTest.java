package webshop;
import org.junit.Test;
import junit.framework.*;
import org.junit.*;

import static org.hamcrest.CoreMatchers.equalTo;
//
// FIXME this test is running in jenkins under the name of Junit demo
// It doesnt have a scheduled built into it though
//

public class MyUnitTest extends TestCase{
    
public static void main(String[] args){
	System.out.print("TESTING MAIN TEST");
}
    
	@Test
	public void testfail() {
//        MyUnit myUnit = new MyUnit();

        String result = ("onetwo");

       assertEquals("oneeetwo", result);

    }
	@Test
	public void testsucces() {
//        MyUnit myUnit = new MyUnit();

        String result = ("onetwo");

       assertEquals("onetwo", result);

    }
}
