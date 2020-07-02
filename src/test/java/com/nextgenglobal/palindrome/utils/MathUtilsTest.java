package com.nextgenglobal.palindrome.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MathUtilsTest {

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void isPalindromeTest() {
	   String str = "malayalam";
	   boolean isPalindrome = MathUtils.isPalindrome(str);
	   assertEquals(true, isPalindrome);
	   
	   String str1 = "notmalayalam";
	   isPalindrome = MathUtils.isPalindrome(str1);
	   assertEquals(false, isPalindrome);
	}
}
