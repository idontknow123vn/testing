package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
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

import com.example.demo.dto.quizz_dto;
import com.example.demo.service.choose_many_service;
import com.example.demo.service.quizz_service;
import com.example.demo.service.writing_service;

@RestController
@CrossOrigin(origins = "http://localhosyt:5500")
@RequestMapping("api/quizz")
public class quizz_controller {
	@Autowired
	private quizz_service quizz_service;
	@Autowired
	private choose_many_service choose_many_service;
	@Autowired
	private writing_service writing_service;
	
	@GetMapping("/{idquizz}")
	public ResponseEntity<Object> getQuizzById(@PathVariable long idquizz){
		quizz_dto foundDto = quizz_service.getQuizzById(idquizz);
		Map<String, Object> map = new LinkedHashMap<>();
		if(foundDto != null) {
			Object writing = writing_service.getListAnswerByIdquizz(idquizz);
			Object many = choose_many_service.getListAnswerByIdquizz(idquizz);
			map.put("writing", writing);
			map.put("many", many);
			BeanUtils.copyProperties(map, foundDto);
		}
		return new ResponseEntity<Object>(foundDto, HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<Object> getAllQuizz(){
		List<quizz_dto> list = quizz_service.getAllQuizz();
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> createQuizz(@RequestBody quizz_dto dto){
		quizz_dto createdDto = quizz_service.createQuizz(dto);
		return new ResponseEntity<Object>(createdDto, HttpStatus.CREATED);
	}
	@PutMapping("/{idquizz}")
	public ResponseEntity<Object> updateQuizz(@PathVariable("idquizz") long idquizz, @RequestBody quizz_dto dto){
		dto.setIdquizz(idquizz);
		quizz_dto updatedQuizz = quizz_service.updateQuizz(dto);
		return new ResponseEntity<Object>(updatedQuizz, HttpStatus.OK);
	}
	@DeleteMapping("/{idquizz}")
	public ResponseEntity<Object> deleteQuizz(@PathVariable("idquizz") long idquizz){
		quizz_service.deleteQuizz(idquizz);
		return new ResponseEntity<Object>("quizz deleted successfully", HttpStatus.OK);
	}
	@GetMapping("/generate")
	public ResponseEntity<Object> generateQuizz(){
		List<quizz_dto> list = quizz_service.generateQuizz();
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
}
