package junitTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeopleTest {

	@Test
	public void testGetName() {
		People p = new People();
		p.getName();
	}

}
