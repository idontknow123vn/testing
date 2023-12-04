package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.choose_many_entity;

public interface choose_many_repos extends JpaRepository<choose_many_entity, Long>{
	@Query("SELECT NEW com.example.demo.entities.choose_many_entity(entity.idanswer, entity.answer, entity.isRight, entity.idquizz)"
			+ "FROM choose_many_entity AS entity WHERE entity.idquizz=:idquizz")
	List<choose_many_entity> getListAnswerByIdquizz(long idquizz);
}
