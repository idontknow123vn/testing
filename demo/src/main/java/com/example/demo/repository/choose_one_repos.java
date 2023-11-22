package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.choose_one_entity;

public interface choose_one_repos extends JpaRepository<choose_one_entity, Long> {

}
