package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.choose_one_dto;
import com.example.demo.service.choose_one_service;

@RestController
@RequestMapping("api/quizz/choose-one")
public class choose_one_controller {
	@Autowired
	private choose_one_service choose_one_service;
	
	@GetMapping("/{idquizz}")
	public ResponseEntity<Object> getAnswerById(@PathVariable("idquizz") long idquizz){
		choose_one_dto findDto = choose_one_service.getAnswer(idquizz);
		return new ResponseEntity<Object>(findDto, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> createAnswer(@RequestBody choose_one_dto dto){
		choose_one_dto createdDto = choose_one_service.createAnswer(dto);
		return new ResponseEntity<Object>(createdDto, HttpStatus.CREATED);
	}
	@PutMapping("/{idquizz}")
	public ResponseEntity<Object> updateAnswer(@PathVariable("idquizz") long idquizz, @RequestBody choose_one_dto dto){
		dto.setIdquizz(idquizz);
		choose_one_dto updatedDto = choose_one_service.updateAnswer(dto);
		return new ResponseEntity<Object>(updatedDto, HttpStatus.OK);
	}
	@DeleteMapping("/{idquizz}")
	public ResponseEntity<Object> deleteAnswer(@PathVariable("idquizz") long idquizz){
		choose_one_service.deleteAnswer(idquizz);
		return new ResponseEntity<Object>("Answer deleted successfully", HttpStatus.OK);
	}
}
