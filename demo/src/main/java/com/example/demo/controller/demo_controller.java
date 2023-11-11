package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demo_controller {
	@GetMapping("/main")
	public String controller_main() {
		return "login";
	}
}
