package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.demo.dto.writing_dto;
import com.example.demo.service.writing_service;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("api/quizz/writing")
public class writing_controller {
	@Autowired
	private writing_service writing_service;
	@GetMapping("/{idanswer}")
	public ResponseEntity<Object> getAnswerByIdanswer(@PathVariable("idanswer") long idanswer){
		writing_dto dto = writing_service.getAnswerByIdanswer(idanswer);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> createAnswer(@RequestBody writing_dto dto){
		writing_dto createdDto = writing_service.createAnswer(dto);
		return new ResponseEntity<>(createdDto, HttpStatus.OK);
	}
	@PutMapping("/{idanswer}")
	public ResponseEntity<Object> updateAnswer(@PathVariable("idanswer") long idanswer, @RequestBody writing_dto dto){
		dto.setIdanswer(idanswer);
		writing_dto updatedDto = writing_service.updateAnswer(dto);
		return new ResponseEntity<Object>(updatedDto, HttpStatus.OK);
	}
	@DeleteMapping("/{idanswer}")
	public ResponseEntity<Object> deleteAnswer(@PathVariable("idanswer") long idanswer){
		writing_service.deleteAnswer(idanswer);
		return new ResponseEntity<Object>("Answer deleted successfully", HttpStatus.OK);
	}
}
