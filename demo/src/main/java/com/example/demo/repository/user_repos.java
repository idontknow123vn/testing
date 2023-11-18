package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.user_entity;

@Repository
public interface user_repos extends JpaRepository<user_entity, Integer> {
//	@Override
//	@Query(value = "select user.iduser, user.password, user.name, user.gender, user.dateCreated, user.status "
//			+ "from pbl4.user as user",
//			nativeQuery = true)
//	List<user_entity> findAll();
}
