package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.user;

@Repository
public interface user_repos extends JpaRepository<user, Integer> {

}
