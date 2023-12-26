package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.quizz_entity;

public interface quizz_repos extends JpaRepository<quizz_entity, Long> {
	@Query("SELECT entity "
			+ "FROM quizz_entity AS entity "
			+ "ORDER BY function('RAND')")
	List<quizz_entity> generateQuiz(Pageable pageable);
	
	@Query("SELECT entity "
			+ "FROM quizz_entity AS entity "
			+ "WHERE entity.subject=:subject "
			+ "ORDER BY function('RAND')")
	List<quizz_entity> generateQuiz(Pageable pageable, String subject);
	
	@Query("SELECT entity "
			+ "FROM quizz_entity AS entity "
			+ "WHERE entity.subject=:subject AND entity.difficulty=:difficulty "
			+ "ORDER BY function('RAND')")
	List<quizz_entity> generateQuiz(Pageable pageable, String subject, int difficulty);
	
	@Query("SELECT entity "
			+ "FROM quizz_entity AS entity "
			+ "WHERE entity.difficulty=:difficulty "
			+ "ORDER BY function('RAND')")
	List<quizz_entity> generateQuiz(Pageable pageable, int difficulty);
	
}
