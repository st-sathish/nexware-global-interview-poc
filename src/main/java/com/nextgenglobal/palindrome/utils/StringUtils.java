package com.nextgenglobal.palindrome.utils;

public final class StringUtils {

	private StringUtils() {
		
	}
	
	public static String reverse(final String str) {
		StringBuilder result = new StringBuilder();
		int strLength = str.length();
		while(strLength > 0) {
			result.append(str.charAt(strLength - 1));
			strLength--;
		}
		return result.toString();
	}
}
