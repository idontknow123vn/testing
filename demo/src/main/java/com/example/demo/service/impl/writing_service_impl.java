package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.DtoInstantiatingConverter;
import org.springframework.stereotype.Service;

import com.example.demo.dto.writing_dto;
import com.example.demo.entities.writing_entity;
import com.example.demo.mappers.writing_mapper;
import com.example.demo.repository.writing_repos;
import com.example.demo.service.writing_service;

@Service
public class writing_service_impl implements writing_service {
	
	@Autowired
	private writing_repos writing_repos;
	
	@Override
	public writing_dto createAnswer(writing_dto dto) {
		// TODO Auto-generated method stub
		writing_entity entity = writing_mapper.mapToWriting_entity(dto);
		writing_entity savedEntity = writing_repos.save(entity);
		return writing_mapper.mapToWriting_dto(savedEntity);
	}

	@Override
	public writing_dto getAnswerByIdanswer(long idanswer) {
		// TODO Auto-generated method stub
		writing_entity entity = writing_repos.findById(idanswer).get();
		
		return writing_mapper.mapToWriting_dto(entity);
	}

	@Override
	public List<writing_dto> getListAnswerByIdquizz(long idquizz) {
		// TODO Auto-generated method stub
		List<writing_entity> entities = writing_repos.getListAnswerByIdquizz(idquizz);
		
		return entities.stream().map(writing_mapper::mapToWriting_dto).collect(Collectors.toList());
	}

	@Override
	public writing_dto updateAnswer(writing_dto dto) {
		// TODO Auto-generated method stub
		writing_entity entity = writing_repos.findById(dto.getIdanswer()).get();
		entity.setAnswer(dto.getAnswer());
		writing_entity updatedEntity = writing_repos.save(entity);
		return writing_mapper.mapToWriting_dto(updatedEntity);
	}

	@Override
	public void deleteAnswer(long idanswer) {
		// TODO Auto-generated method stub
		writing_repos.deleteById(idanswer);
	}

}
