package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.quizz_entity;

public interface quizz_repos extends JpaRepository<quizz_entity, Long> {

}
