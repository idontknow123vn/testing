package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.user_dto;

public interface user_service {
	user_dto createUser(user_dto user_dto);
	user_dto getUserById(long iduser);
	List<user_dto> getAllUser();
	List<user_dto> getTopTen();
	user_dto updateUser(user_dto user);
	void deleteUser(long iduser);
	user_dto login(List<String> input);
	void logout(user_dto dto);
}
