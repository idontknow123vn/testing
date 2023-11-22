package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.choose_many_dto;
import com.example.demo.entities.choose_many_entity;
import com.example.demo.entities.writing_entity;
import com.example.demo.mappers.choose_many_mapper;
import com.example.demo.mappers.writing_mapper;
import com.example.demo.repository.choose_many_repos;
import com.example.demo.service.choose_many_service;

@Service
public class choose_many_service_impl implements choose_many_service {
	
	@Autowired
	private choose_many_repos choose_many_repos;

	@Override
	public choose_many_dto createAnswer(choose_many_dto dto) {
		// TODO Auto-generated method stub
		choose_many_entity entity = choose_many_mapper.mapToChoose_many_entity(dto);
		choose_many_entity savedEntity = choose_many_repos.save(entity);
		return choose_many_mapper.mapToChoose_many_dto(savedEntity);
	}

	@Override
	public choose_many_dto getAnswerByIdanswer(long idanswer) {
		// TODO Auto-generated method stub
		choose_many_entity entity = choose_many_repos.findById(idanswer).get();
		
		return choose_many_mapper.mapToChoose_many_dto(entity);
	}

	@Override
	public List<choose_many_dto> getListAnswerByIdquizz(long idquizz) {
		// TODO Auto-generated method stub
		List<choose_many_entity> entities = choose_many_repos.getListAnswerByIdquizz(idquizz);
		
		return entities.stream().map(choose_many_mapper::mapToChoose_many_dto).collect(Collectors.toList());
	}

	@Override
	public choose_many_dto updateAnswer(choose_many_dto dto) {
		// TODO Auto-generated method stub
		choose_many_entity entity = choose_many_repos.findById(dto.getIdanswer()).get();
		entity.setAnswer(dto.getAnswer());
		entity.setRight(dto.isRight());
		choose_many_entity updatedEntity = choose_many_repos.save(entity);
		return choose_many_mapper.mapToChoose_many_dto(updatedEntity);
	}

	@Override
	public void deleteAnswer(long idanswer) {
		// TODO Auto-generated method stub
		choose_many_repos.deleteById(idanswer);
	}

}
