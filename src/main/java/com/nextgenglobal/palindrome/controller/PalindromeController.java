package com.nextgenglobal.palindrome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nextgenglobal.palindrome.service.PalindromeService;

@Controller
public class PalindromeController {

	private PalindromeService palindromeService;
	
	@Autowired
	public PalindromeController(final PalindromeService palindromeService) {
		this.palindromeService = palindromeService;
	}
	
	@GetMapping
    public ModelAndView index() {
		final ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("data", this.palindromeService.retrieveAll());
		return modelAndView;
    }
	
	/*
	 * @PostMapping public ModelAndView create() { final ModelAndView modelAndView =
	 * new ModelAndView("index"); return modelAndView; }
	 * 
	 * @PostMapping public ModelAndView autoComplete() { final ModelAndView
	 * modelAndView = new ModelAndView("index"); return modelAndView; }
	 */
}
