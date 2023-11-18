package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.normal_dto;
import com.example.demo.entities.normal_entity;
import com.example.demo.mappers.normal_mapper;
import com.example.demo.repository.normal_repos;
import com.example.demo.service.normal_service;

@Service
public class normal_service_impl implements normal_service {
	@Autowired
	private normal_repos normal_repos;

	@Override
	public normal_dto getNormalStatisticById(int iduser) {
		// TODO Auto-generated method stub
		Optional<normal_entity> entities = normal_repos.findById(iduser);
		normal_dto dto = normal_mapper.mapToNormal_dto(entities.get());
		return dto;
	}

	@Override
	public normal_dto createNormal_statistic(normal_dto statistic) {
		// TODO Auto-generated method stub
		normal_entity entity = normal_mapper.mapToNormal_entity(statistic);
		normal_entity saved_entity = normal_repos.save(entity);
		normal_dto saved_dto = normal_mapper.mapToNormal_dto(saved_entity);
		return saved_dto;
	}

	@Override
	public normal_dto updateNormal_statistic(normal_dto statistic) {
		// TODO Auto-generated method stub
		normal_entity existing_Entity = normal_repos.findById(statistic.getIduser()).get();
		existing_Entity.setGamePlayed(statistic.getGamePlayed());
		existing_Entity.setGameWon(statistic.getGameWon());
		normal_entity update_Entity = normal_repos.save(existing_Entity);
		return normal_mapper.mapToNormal_dto(update_Entity);
	}

	@Override
	public void deleteNormal_statistic(int iduser) {
		// TODO Auto-generated method stub
		normal_repos.deleteById(iduser);
	}

}
