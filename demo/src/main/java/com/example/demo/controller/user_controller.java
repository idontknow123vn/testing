package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.user_dto;
import com.example.demo.service.user_service;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/user")
public class user_controller {
	@Autowired
	private user_service user_service;
	
	@GetMapping
	public ResponseEntity<Object> getAllUser(){
		List<user_dto> users = user_service.getAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	@GetMapping("/{iduser}")
	public ResponseEntity<Object> getUserById(@PathVariable("iduser") int iduser){
		user_dto find_user = user_service.getUserById(iduser);
		return new ResponseEntity<Object>(find_user, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> createUser(@RequestBody user_dto user){
		user_dto save_user = user_service.createUser(user);
		return new ResponseEntity<Object>(save_user, HttpStatus.CREATED);	
	}
	@PutMapping("/{iduser}")
	public ResponseEntity<Object> updateUser(@PathVariable("iduser") int iduser, @RequestBody user_dto user){
		user.setIduser(iduser);
		user_dto updated_user = user_service.updateUser(user);
		return new ResponseEntity<Object>(updated_user, HttpStatus.OK);	
	}
	@DeleteMapping("/{iduser}")
	public ResponseEntity<String> deleteUser(@PathVariable("iduser") int iduser){
		user_service.deleteUser(iduser);
		return new ResponseEntity<String>("User successfully deleted", HttpStatus.OK);
	}
	@PutMapping(value = "/login")
	public ResponseEntity<Object> login(@RequestBody List<String> list){
		user_dto foundUser = user_service.login(list);
		return new ResponseEntity<Object>(foundUser, HttpStatus.OK);
	}
	@PutMapping(value = "/logout")
	public ResponseEntity<String> logout(@RequestBody user_dto dto){
		user_service.logout(dto);
		return new ResponseEntity<String>("User successfully deleted", HttpStatus.OK);
	}
}
