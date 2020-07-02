package com.nextgenglobal.palindrome.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public ModelAndView index() throws JsonProcessingException {
		final ModelAndView modelAndView = new ModelAndView("index", "palindromeForm", new PalindromeForm());
		ObjectMapper mapper = new ObjectMapper();
		modelAndView.addObject("items", mapper.writeValueAsString(this.palindromeService.retrieveAll()));
		return modelAndView;
    }
	
	@PostMapping(path = "/create")
	public String create(@ModelAttribute("palindromeForm") PalindromeForm palindromeForm) {
		palindromeService.create(palindromeForm);
		return "redirect:/";
	}
	
	@GetMapping(path = "/autocomplete")
	public @ResponseBody List<String> autoComplete(@RequestParam("term") String query) {
		final List<String> results = this.palindromeService.autocomplete(query);
		return results;
	}
}
