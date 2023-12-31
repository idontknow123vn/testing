package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.example.demo.dto.choose_many_dto;
import com.example.demo.service.choose_many_service;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("api/quizz/choose-many")
public class choose_many_controller {
	@Autowired
	private choose_many_service service;
	@GetMapping("/{idanswer}")
	public ResponseEntity<Object> getAnswerByIdanswer(@PathVariable("idanswer") long idanswer){
		choose_many_dto dto = service.getAnswerByIdanswer(idanswer);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> createAnswer(@RequestBody choose_many_dto dto){
		choose_many_dto createdDto = service.createAnswer(dto);
		return new ResponseEntity<Object>(createdDto,HttpStatus.CREATED);
	}
	@PutMapping("/{idanswer}")
	public ResponseEntity<Object> updateAnswer(@PathVariable("idanswer") long idanswer, @RequestBody choose_many_dto dto){
		dto.setIdanswer(idanswer);
		choose_many_dto updatedDto = service.updateAnswer(dto);
		return new ResponseEntity<Object>(updatedDto, HttpStatus.OK);
	}
	@DeleteMapping("/{idanswer}")
	public ResponseEntity<Object> deleteAnswer(@PathVariable("idanswer") long idanswer){
		service.deleteAnswer(idanswer);
		return new ResponseEntity<Object>("Answer deleted successfully", HttpStatus.OK);
	}
}
