package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.user_entity;

@Repository
public interface user_repos extends JpaRepository<user_entity, Long> {
	@Query("SELECT NEW com.example.demo.entities.user_entity(entity.iduser, entity.password, entity.name, entity.username, entity.gender, entity.dateCreated, entity.status, entity.normal_statistic, entity.rank_statistic)"
			+ "FROM user_entity AS entity WHERE entity.username=:username AND entity.password=:password")
	user_entity login(String username, String password);
	
	@Query("SELECT entity FROM user_entity AS entity ORDER BY entity.rank_statistic.point DESC")
	List<user_entity> getTopTen(Pageable pageable);
}
