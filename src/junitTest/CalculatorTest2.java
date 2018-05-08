package junitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class CalculatorTest2 {
	private int first;
	private int second;
	private int expected;
	Calculator c;
	public CalculatorTest2(int first,int second,int expected){
		this.first = first;
		this.second = second;
		this.expected = expected;
	}
	@Parameters
	public static Collection initpara(){
		//List b = new ArrayList();
		
		Integer[][] a = new Integer[][]{{1,2,3},{4,2,5},{3,6,9},{1,1,2}};
		return Arrays.asList(a);
		
	}
	@Before
	public void init(){
		c = new Calculator();
	}
	@Test
	public void testAdd() {
		System.out.println("first:"+first+"second:"+second+"expected:"+expected);
		Assert.assertEquals(expected, c.add(first, second));
	}
	@Ignore
	public void testSub() {
		fail("ипн╢й╣ож");
	}

}
