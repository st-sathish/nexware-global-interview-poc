package com.nextgenglobal.palindrome.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextgenglobal.palindrome.data.PalindromeData;
import com.nextgenglobal.palindrome.domain.Palindrome;
import com.nextgenglobal.palindrome.domain.PalindromeRepository;
import com.nextgenglobal.palindrome.form.PalindromeForm;
import com.nextgenglobal.palindrome.form.PalindromeFormValidator;

@Service
public class PalindromeServiceImpl implements PalindromeService {
	
	private final PalindromeRepository palindromeRepository;
	
	private final PalindromeFormValidator palindromeFormValidator;
	
	private final PalindromeRowMapper palindromeRowMapper = new PalindromeRowMapper();
	
	@Autowired
	public PalindromeServiceImpl(final PalindromeRepository palindromeRepository,
			final PalindromeFormValidator palindromeFormValidator) {
		this.palindromeRepository = palindromeRepository;
		this.palindromeFormValidator = palindromeFormValidator;
	}

	@Override
	public List<PalindromeData> retrieveAll() {
		final List<Palindrome> palindromeList = this.palindromeRepository.findAll();
		return palindromeRowMapper.map(palindromeList);
	}

	@Override
	public void create(final PalindromeForm form) {
		palindromeFormValidator.validateForm(form);
		final Palindrome palindrome = Palindrome.from(form);
		palindromeRepository.save(palindrome);
	}
	
	@Override
	public List<String> autocomplete(final String query) {
		final List<Palindrome> palindromeList = this.palindromeRepository.findByNameContaining(query);
		final List<String> results = new ArrayList<>();
		for(Palindrome palindrome: palindromeList) {
			results.add(palindrome.getName());
		}
		return results;
	}

	private static class PalindromeRowMapper {
		
		public PalindromeData map(final Palindrome palindrome) {
			return PalindromeData.newInstance(palindrome.getId(), palindrome.getName());
		}
		
		public List<PalindromeData> map(final List<Palindrome> palindromeList) {
			final List<PalindromeData> palindromeListData = new ArrayList<>();
			for(final Palindrome palindrome : palindromeList) {
				palindromeListData.add(map(palindrome));
			}
			return palindromeListData;
		}
	}
}
