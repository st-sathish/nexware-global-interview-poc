package com.nextgenglobal.palindrome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nextgenglobal.palindrome.form.PalindromeForm;
import com.nextgenglobal.palindrome.service.PalindromeService;

@Controller
public class PalindromeController {

	private PalindromeService palindromeService;
	
	@Autowired
	public PalindromeController(final PalindromeService palindromeService) {
		this.palindromeService = palindromeService;
	}
	
	@GetMapping(path = "/")
    public ModelAndView index() {
		final ModelAndView modelAndView = new ModelAndView("index", "palindromeForm", new PalindromeForm());
		modelAndView.addObject("items", this.palindromeService.retrieveAll());
		return modelAndView;
    }
	
	@PostMapping(path = "/create")
	public ModelAndView create(@ModelAttribute("palindromeForm") PalindromeForm palindromeForm) {
		palindromeService.create(palindromeForm);
		final ModelAndView modelAndView = new ModelAndView("index", "palindromeForm", new PalindromeForm());
		return modelAndView;
	}
	
	@PostMapping(path = "/autocomplete")
	public ModelAndView autoComplete() {
		final ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
}
