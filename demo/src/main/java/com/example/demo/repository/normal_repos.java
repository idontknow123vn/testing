package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.normal_entity;

public interface normal_repos extends JpaRepository<normal_entity, Long> {

}
