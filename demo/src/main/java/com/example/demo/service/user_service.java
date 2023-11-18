package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.user_dto;
import com.example.demo.entities.user_entity;
import com.example.demo.repository.user_repos;

public interface user_service {
	user_dto createUser(user_dto user_dto);
	user_dto getUserById(int iduser);
	List<user_dto> getAllUser();
	user_dto updateUser(user_dto user);
	void deleteUser(int iduser);
}
