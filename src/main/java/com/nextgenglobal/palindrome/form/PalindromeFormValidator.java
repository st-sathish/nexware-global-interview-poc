package com.nextgenglobal.palindrome.form;

import org.springframework.stereotype.Component;

import com.nextgenglobal.palindrome.exception.InvalidPalindromeException;
import com.nextgenglobal.palindrome.utils.MathUtils;

@Component
public class PalindromeFormValidator {

	public void validateForm(final PalindromeForm form) {
		if(form.getName() == null || form.getName().equals("")) {
			throw new RuntimeException("form name field shouldn't be empty");
		}
		if(!MathUtils.isPalindrome(form.getName())) {
			throw new InvalidPalindromeException("Invalid Palindrome");
		}
	}
}
