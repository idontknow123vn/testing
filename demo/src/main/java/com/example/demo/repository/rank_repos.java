package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.rank_entity;

public interface rank_repos extends JpaRepository<rank_entity, Long> {
	
}
