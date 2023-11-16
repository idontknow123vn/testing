package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.account;

@Repository
public class account_repository {
	public interface account_repos extends CrudRepository<account, Integer> {}
}
