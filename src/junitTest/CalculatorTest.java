package junitTest;

import junit.framework.Assert;

import org.junit.*;
import org.junit.Test;

public class CalculatorTest {
	@Rule 
	public MyRule mr = new MyRule(4);
	
	@Test
	public void testAdd() {
		Calculator c = new Calculator();
        int result = c.add(1, 2);
        Assert.assertEquals("Ê²Ã´¶«Î÷",result, 3);
	}

	@Ignore
	public void testSub() {
		Calculator c = new Calculator();
        int result = c.sub(5, 2);
        Assert.assertEquals(result, 3);
	}
	
	@Before
	public void testBefore(){
		System.out.println("testBefore");
	}
	
	@BeforeClass
	public static void testBeforeClass(){
		System.out.println("testBeforeClass");
	}
	
	@After
	public void testAfter(){
		System.out.println("testAfter");
	}
	
	@AfterClass
	public static void testAfterClass(){
		System.out.println("testAfterClass");
	} 
}
