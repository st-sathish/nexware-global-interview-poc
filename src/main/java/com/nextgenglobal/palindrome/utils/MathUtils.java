package com.nextgenglobal.palindrome.utils;

public final class MathUtils {

	private MathUtils() {
		
	}
	
	public static boolean isPalindrome(final String name) {
		final String reverseStr = StringUtils.reverse(name);
		if(name.toLowerCase().equals(reverseStr.toLowerCase())) {
			return true;
		}
		return false;
	}
}
