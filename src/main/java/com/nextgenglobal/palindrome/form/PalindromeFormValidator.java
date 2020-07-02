package com.nextgenglobal.palindrome.form;

import org.springframework.stereotype.Component;

import com.nextgenglobal.palindrome.exception.InvalidPalindromeException;
import com.nextgenglobal.palindrome.utils.MathUtils;

@Component
public class PalindromeFormValidator {

	public void validateForm(final PalindromeForm form) {
		String name = form.getName();
		if(form.getName() == null || form.getName().equals("")) {
			throw new RuntimeException("Name shouldn't be empty");
		}
		if(name != null && !name.matches("^[a-zA-Z]*$")) {
			throw new RuntimeException("Name should allow only Alphabets");
		}
		if(form.getName().trim().length() > 100) {
			throw new RuntimeException("Name should be a range 0 - 100");
		}
		if(!MathUtils.isPalindrome(form.getName())) {
			throw new InvalidPalindromeException("Palindrome not valid");
		}
	}
}
