package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.choose_one_dto;
import com.example.demo.entities.choose_one_entity;
import com.example.demo.mappers.choose_one_mapper;
import com.example.demo.repository.choose_one_repos;
import com.example.demo.service.choose_one_service;

@Service
public class choose_one_service_impl implements choose_one_service {
	
	@Autowired
	private choose_one_repos choose_one_repos;

	@Override
	public choose_one_dto createAnswer(choose_one_dto dto) {
		// TODO Auto-generated method stub
		choose_one_entity entity = choose_one_mapper.mapToChoose_one_entity(dto);
		choose_one_entity savedEntity = choose_one_repos.save(entity);
		return choose_one_mapper.mapToChoose_one_dto(savedEntity);
	}

	@Override
	public choose_one_dto getAnswer(long idquizz) {
		// TODO Auto-generated method stub
		choose_one_entity entity = choose_one_repos.findById(idquizz).get();
		
		return choose_one_mapper.mapToChoose_one_dto(entity);
	}

	@Override
	public choose_one_dto updateAnswer(choose_one_dto dto) {
		// TODO Auto-generated method stub
		choose_one_entity entity = choose_one_repos.findById(dto.getIdquizz()).get();
		entity.setRight_answer(dto.getRight_answer());
		entity.setWrong_answer1(dto.getWrong_answer1());
		entity.setWrong_answer2(dto.getWrong_answer2());
		entity.setWrong_answer3(dto.getWrong_answer3());
		choose_one_entity savedEntity = choose_one_repos.save(entity);
		return choose_one_mapper.mapToChoose_one_dto(savedEntity);
	}

	@Override
	public void deleteAnswer(long idquizz) {
		// TODO Auto-generated method stub
		choose_one_repos.deleteById(idquizz);
	}

}
