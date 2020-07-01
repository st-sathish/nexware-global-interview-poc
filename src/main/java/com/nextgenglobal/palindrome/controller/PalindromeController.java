package com.nextgenglobal.palindrome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PalindromeController {

	@GetMapping
    public String index() {
        return "index";
    }
}
