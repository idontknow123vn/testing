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

import com.example.demo.dto.normal_dto;
import com.example.demo.service.normal_service;

@RestController
@RequestMapping("api/user/statistic/normal")
public class normal_controller {
	@Autowired
	private normal_service service;
	
	@GetMapping("/{iduser}")
	public ResponseEntity<Object> getNormal_statById(@PathVariable("iduser") int iduser){
		normal_dto find_Dto = service.getNormalStatisticById(iduser);
		return new ResponseEntity<Object>(find_Dto,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> createNormal_stat(@RequestBody normal_dto dto){
		normal_dto create_Dto = service.createNormal_statistic(dto);
		return new ResponseEntity<Object>(create_Dto, HttpStatus.CREATED);
	}
	@PutMapping("/{iduser}")
	public ResponseEntity<Object> updateNormal_stat(@PathVariable("iduser") int iduser, @RequestBody normal_dto dto){
		dto.setIduser(iduser);
		normal_dto updateDto = service.updateNormal_statistic(dto);
		return new ResponseEntity<Object>(updateDto, HttpStatus.CREATED);
	}
	@DeleteMapping("/{iduser}")
	public ResponseEntity<String> deleteNormal_stat(@PathVariable("iduser") int iduser){
		service.deleteNormal_statistic(iduser);
		return new ResponseEntity<String>("Delete statistic successfully", HttpStatus.OK);
	}
}
