package com.majjel.majjel.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model, HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("username", authentication.getName());
		return "home";
	}

	@GetMapping("/tools")
	public String tools() {
		return "tools";
	}

	// Dynamic views
	@GetMapping("/tools/nmap")
	public String subnetCalc() {
		return "tools/nmap";
	}

	@GetMapping("/tools/google")
	public String hash() {
		return "tools/google";
	}

}