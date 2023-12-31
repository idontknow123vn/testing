package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.user_entity;

import jakarta.transaction.Transactional;

@Repository
public interface user_repos extends JpaRepository<user_entity, Long> {
	@Query("SELECT NEW com.example.demo.entities.user_entity(entity.iduser, entity.password, entity.name, entity.username, entity.gender, entity.dateCreated, entity.status, entity.role, entity.normal_statistic, entity.rank_statistic)"
			+ "FROM user_entity AS entity WHERE entity.username=:username AND entity.password=:password")
	user_entity login(String username, String password);
	
	@Query("SELECT entity FROM user_entity AS entity ORDER BY entity.rank_statistic.point DESC")
	List<user_entity> getTopTen(Pageable pageable);
	
	 @Transactional
	 @Modifying
	 @Query("UPDATE user_entity u SET u.password = :password WHERE u.username = :username")
	void updatePassword(String username, String password);
	
	@Query("SELECT COUNT(u) > 0 FROM user_entity u WHERE u.username = :username")
    boolean existsByUsername(String username);
	
	@Query("SELECT NEW com.example.demo.entities.user_entity(entity.iduser, entity.password, entity.name, entity.username, entity.gender, entity.dateCreated, entity.status, entity.role, entity.normal_statistic, entity.rank_statistic)"
			+ "FROM user_entity AS entity WHERE entity.username=:username")
	user_entity isEmailExist(String username);
	@Query("SELECT NEW com.example.demo.entities.user_entity(entity.iduser, entity.password, entity.name, entity.username, entity.gender, entity.dateCreated, entity.status, entity.role, entity.normal_statistic, entity.rank_statistic)"
			+ "FROM user_entity AS entity WHERE entity.name=:name")
	user_entity isNameExist(String name);
	
}
