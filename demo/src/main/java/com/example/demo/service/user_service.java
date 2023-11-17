package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entities.user;
import com.example.demo.repository.user_repos;

@Service
public class user_service {
	private final user_repos user_repos;
	@Autowired
	public user_service(user_repos user_repos) {
		this.user_repos = user_repos;
	}
	public Optional<user> findUser(int id){
		return user_repos.findById(id);
	}
	public List<user> findAllUsers(){
		return user_repos.findAll();
	}
}
