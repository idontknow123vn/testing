package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.choose_one_dto;
import com.example.demo.dto.quizz_dto;
import com.example.demo.entities.choose_one_entity;
import com.example.demo.entities.quizz_entity;
import com.example.demo.mappers.choose_one_mapper;
import com.example.demo.mappers.quizz_mapper;
import com.example.demo.repository.choose_many_repos;
import com.example.demo.repository.choose_one_repos;
import com.example.demo.repository.quizz_repos;
import com.example.demo.repository.writing_repos;
import com.example.demo.service.quizz_service;

@Service
public class quizz_service_impl implements quizz_service {
	
	@Autowired
	private quizz_repos quizz_repos;
	@Autowired
	private choose_one_repos choose_one_repos;
	@Autowired
	private choose_many_repos choose_many_repos;
	@Autowired
	private writing_repos writing_repos;

	@Override
	public quizz_dto createQuizz(quizz_dto dto) {
		// TODO Auto-generated method stub
		quizz_entity entity = quizz_mapper.mapToQuizz_entity(dto);
		choose_one_entity one = choose_one_mapper.mapToChoose_one_entity(new choose_one_dto());
		entity.setChoose_one(one);
		one.setQuizz(entity);
		quizz_entity createdEntity = quizz_repos.save(entity);
		
		return quizz_mapper.mapToQuizz_dto(createdEntity);
	}

	@Override
	public quizz_dto getQuizzById(long idquizz) {
		// TODO Auto-generated method stub
		quizz_entity findEntity = quizz_repos.findById(idquizz).get();
		
		return quizz_mapper.mapToQuizz_dto(findEntity);
	}

	@Override
	public List<quizz_dto> getAllQuizz() {
		// TODO Auto-generated method stub
		List<quizz_entity> allEntities = quizz_repos.findAll();
		return allEntities.stream().map(quizz_mapper::mapToQuizz_dto).collect(Collectors.toList());
	}

	@Override
	public quizz_dto updateQuizz(quizz_dto dto) {
		// TODO Auto-generated method stub
		quizz_entity updateEntity = quizz_repos.findById(dto.getIdquizz()).get();
		updateEntity.setQuizz_info(dto.getQuizz_info());
		updateEntity.setPicture(dto.getPicture());
		updateEntity.setDifficulty(dto.getDifficulty());
		updateEntity.setSubject(dto.getSubject());
		updateEntity.setTimeAnswered(dto.getTimeAnswered());
		quizz_entity returnEntity = quizz_repos.save(updateEntity);
		return quizz_mapper.mapToQuizz_dto(returnEntity);
	}

	@Override
	public void deleteQuizz(long idquizz) {
		// TODO Auto-generated method stub
		choose_many_repos.deleteAllInBatch(choose_many_repos.getListAnswerByIdquizz(idquizz));
		writing_repos.deleteAllInBatch(writing_repos.getListAnswerByIdquizz(idquizz));
		choose_one_repos.deleteById(idquizz);
		quizz_repos.deleteById(idquizz);
	}
	
}
