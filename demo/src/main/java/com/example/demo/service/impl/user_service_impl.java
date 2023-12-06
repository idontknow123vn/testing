package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.normal_dto;
import com.example.demo.dto.rank_dto;
import com.example.demo.dto.user_dto;
import com.example.demo.repository.normal_repos;
import com.example.demo.repository.rank_repos;
import com.example.demo.repository.user_repos;
import com.example.demo.service.user_service;

import ch.qos.logback.core.joran.action.NewRuleAction;

import com.example.demo.entities.normal_entity;
import com.example.demo.entities.rank_entity;
import com.example.demo.entities.user_entity;
import com.example.demo.mappers.normal_mapper;
import com.example.demo.mappers.rank_mapper;
import com.example.demo.mappers.user_mapper;

@Service
public class user_service_impl implements user_service {
	@Autowired
	private user_repos user_repos;
	
	@Autowired
	private normal_repos normal_repos;
	
	@Autowired
	private rank_repos rank_repos;
	
	@Override
	public user_dto createUser(user_dto user_dto) {
		
		user_entity user_entity = user_mapper.mapToUser_entity(user_dto);
		normal_entity normal = normal_mapper.mapToNormal_entity(new normal_dto());
		rank_entity rank = rank_mapper.mapToRank_entity(new rank_dto());
		user_entity.setNormal_statistic(normal);
		user_entity.setRank_statistic(rank);
		normal.setUser(user_entity);
		rank.setUser(user_entity);
		user_entity saved_user = user_repos.save(user_entity);
		user_dto saved_user_dto = user_mapper.mapToUser_dto(saved_user);
		return saved_user_dto;
		
	}

	@Override
	public user_dto getUserById(long iduser) {
		// TODO Auto-generated method stub
		Optional<user_entity> optional = user_repos.findById(iduser);
		user_dto user_dto = user_mapper.mapToUser_dto(optional.get());
		return user_dto;
	}

	@Override
	public List<user_dto> getAllUser() {
		// TODO Auto-generated method stub
		List<user_entity> list = user_repos.findAll();
		return list.stream().map(user_mapper::mapToUser_dto).collect(Collectors.toList());
	}

	@Override
	public user_dto updateUser(user_dto user) {
		// TODO Auto-generated method stub
		user_entity existing_user= user_repos.findById(user.getIduser()).get();
		existing_user.setName(user.getName());
		existing_user.setGender(user.isGender());
		existing_user.setPassword(user.getPassword());
		user_entity update_user = user_repos.save(existing_user);
		return user_mapper.mapToUser_dto(update_user);
	}

	@Override
	public void deleteUser(long iduser) {
		// TODO Auto-generated method stub
		normal_repos.deleteById(iduser);
		rank_repos.deleteById(iduser);
		user_repos.deleteById(iduser);
	}

	@Override
	public user_dto login(List<String> input) {
		// TODO Auto-generated method stub
		String username = input.get(0);
		String password = input.get(1);
		user_entity foundEntity = user_repos.login(username, password);
		foundEntity.setStatus(true);
		user_entity loginEntity = user_repos.save(foundEntity);
		return user_mapper.mapToUser_dto(loginEntity);
	}

	@Override
	public void logout(user_dto user) {
		// TODO Auto-generated method stub
		user_entity existing_user= user_repos.findById(user.getIduser()).get();
		existing_user.setStatus(false);
		user_repos.save(existing_user);
	}
}
