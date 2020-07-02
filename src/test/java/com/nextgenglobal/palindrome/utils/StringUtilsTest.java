package com.nextgenglobal.palindrome.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class StringUtilsTest {

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void reverseTest() {
		final String arg1 = "malayalam";
		assertEquals(arg1, StringUtils.reverse(arg1));
		
		final String arg2 = "hidden";
		assertNotEquals(arg2, StringUtils.reverse(arg2));
	}
}
