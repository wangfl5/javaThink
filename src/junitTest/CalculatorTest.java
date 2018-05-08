package junitTest;

import junit.framework.Assert;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator c = new Calculator();
        int result = c.add(4, 2);
        Assert.assertEquals("Ê²Ã´¶«Î÷",result, 3);
	}

	@Test
	public void testSub() {
		Calculator c = new Calculator();
        int result = c.sub(5, 2);
        Assert.assertEquals(result, 3);
	}

}
