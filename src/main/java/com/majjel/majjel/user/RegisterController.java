package com.majjel.majjel.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@Controller
public class RegisterController {
	
	 @Autowired
	    private UserRepository userRepository;
	
	@GetMapping(value = "/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	    //model.addAttribute("param.success", true);
	    return "register";
	}
	
	@PostMapping("/register")
	public String processRegister(User user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());	
		user.setPassword(encodedPassword);
	    userRepository.save(user);
	     
	    return "register";
	}
}
