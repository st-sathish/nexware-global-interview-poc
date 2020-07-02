package com.nextgenglobal.palindrome.service;

import java.util.List;

import com.nextgenglobal.palindrome.data.PalindromeData;
import com.nextgenglobal.palindrome.form.PalindromeForm;

public interface PalindromeService {

	List<PalindromeData> retrieveAll();
	
	void create(final PalindromeForm form);
	
	List<String> autocomplete(final String query);
}
