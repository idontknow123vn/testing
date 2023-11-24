package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.writing_entity;

public interface writing_repos extends JpaRepository<writing_entity, Long> {
	@Query("SELECT NEW com.example.demo.entities.writing_entity(entity.idanswer, entity.answer, entity.idquizz)"
			+ "FROM writing_entity AS entity WHERE entity.idquizz=:idquizz")
	List<writing_entity> getListAnswerByIdquizz(long idquizz);
}
