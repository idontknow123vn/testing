package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.user_dto;
import com.example.demo.repository.user_repos;
import com.example.demo.service.user_service;

import com.example.demo.entities.user_entity;
import com.example.demo.mappers.user_mapper;

@Service
public class user_service_impl implements user_service {
	@Autowired
	private user_repos user_repos;
	
	@Override
	public user_dto createUser(user_dto user_dto) {
		
		user_entity user_entity = user_mapper.mapToUser_entity(user_dto);
		user_entity saved_user = user_repos.save(user_entity);
		user_dto saved_user_dto = user_mapper.mapToUser_dto(saved_user);
		return saved_user_dto;
		
	}

	@Override
	public user_dto getUserById(int iduser) {
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
	public void deleteUser(int iduser) {
		// TODO Auto-generated method stub
		user_repos.deleteById(iduser);
	}
}
