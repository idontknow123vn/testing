package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.user;
import com.example.demo.service.user_service;

@RestController
@RequestMapping(path = "api/users")
public class user_controller {
	
	private final user_service user_service;
	
	public user_controller(user_service user_service) {
		this.user_service = user_service;
	}
	
	@GetMapping("{id}")
	public Optional<user> findUser(@PathVariable("id") int id) {
		return user_service.findUser(id);
	}	
	@GetMapping
	public List<user> findAllUsers(){
		return user_service.findAllUsers();
	}
}
