package com.example.demo.service;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import com.example.demo.dto.user_dto;

import jakarta.mail.MessagingException;

public interface user_service {
	user_dto createUser(user_dto user_dto);
	user_dto getUserById(long iduser);
	List<user_dto> getAllUser();
	List<user_dto> getTopTen();
	user_dto updateUser(user_dto user);
	void deleteUser(long iduser);
	user_dto login(List<String> input) throws SecurityException;
	void logout(user_dto dto);
	Integer reset_password(String gmail);
	void update_password(List<String> list);
	Integer cofirm_gmail(List<String> list) throws InvalidAttributesException, IllegalArgumentException,MessagingException;
}
