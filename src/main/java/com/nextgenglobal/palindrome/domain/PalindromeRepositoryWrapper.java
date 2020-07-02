package com.nextgenglobal.palindrome.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PalindromeRepositoryWrapper {
	
	private PalindromeRepository palindromeRepository;
	
	@Autowired
	public PalindromeRepositoryWrapper(final PalindromeRepository palindromeRepository) {
		this.palindromeRepository = palindromeRepository;
	}
	
	public Palindrome findByNameOrThrowException(final String name) {
		return null;
	}

}
