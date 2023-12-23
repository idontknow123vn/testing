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

import com.example.demo.dto.rank_dto;
import com.example.demo.service.rank_service;

@RestController
@CrossOrigin(origins = "http://localhost:5500")
@RequestMapping("api/user/statistic/rank")
public class rank_controller {
	@Autowired
	private rank_service rank_service;
	
	@GetMapping("/{iduser}")
	public ResponseEntity<Object> getRankStatById(@PathVariable("iduser") long iduser){
		rank_dto dto = rank_service.getRankStatById(iduser);
		return new ResponseEntity<Object>(dto, HttpStatus.OK); 
	}
	@PostMapping
	public ResponseEntity<Object> createRankStat(@RequestBody rank_dto dto){
		rank_dto savedDto = rank_service.createRankStat(dto);
		return new ResponseEntity<Object>(savedDto, HttpStatus.CREATED);
	}
	@PutMapping("/{iduser}")
	public ResponseEntity<Object> updateRankStat(@PathVariable("iduser") long iduser, @RequestBody rank_dto dto){
		dto.setIduser(iduser);
		rank_dto updateDto = rank_service.updateRankStat(dto);
		return new ResponseEntity<Object>(updateDto, HttpStatus.OK);
	}
	@DeleteMapping("/{iduser}")
	public ResponseEntity<Object> deleteRankStat(@PathVariable("iduser") long iduser){
		rank_service.deleteRankStat(iduser);
		return new ResponseEntity<Object>("Rank deleted successfully", HttpStatus.OK);
	}
}
