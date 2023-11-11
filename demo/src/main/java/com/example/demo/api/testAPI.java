package com.example.demo.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class testAPI {
	@GetMapping("/login")
	public String test1_API() {
		return "login";
	}
}
