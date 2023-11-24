package com.example.demo.dto;

import java.sql.Date;

import com.example.demo.entities.normal_entity;
import com.example.demo.entities.rank_entity;

public class user_dto {
	private long iduser;
	private String password;
	private String name;
	private String username;
	private boolean gender;
	private Date dateCreated;
	private boolean status;
	private normal_entity normal_statistic;
	private rank_entity rank_statistic;
	public user_dto(long iduser, String password, String name, String username, boolean gender, Date dateCreated, boolean status) {
		super();
		this.iduser = iduser;
		this.password = password;
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.dateCreated = dateCreated;
		this.status = status;
	}
	
	public user_dto(long iduser, String password, String name, String username, boolean gender, Date dateCreated, boolean status,
			normal_entity normal_statistic, rank_entity rank_statistic) {
		super();
		this.iduser = iduser;
		this.password = password;
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.dateCreated = dateCreated;
		this.status = status;
		this.normal_statistic = normal_statistic;
		this.rank_statistic = rank_statistic;
	}
	
	public user_dto() {
		
	}
	
	public normal_entity getNormal_statistic() {
		return normal_statistic;
	}

	public void setNormal_statistic(normal_entity normal_statistic) {
		this.normal_statistic = normal_statistic;
	}

	public rank_entity getRank_statistic() {
		return rank_statistic;
	}

	public void setRank_statistic(rank_entity rank_statistic) {
		this.rank_statistic = rank_statistic;
	}
	public long getIduser() {
		return iduser;
	}
	public void setIduser(long iduser) {
		this.iduser = iduser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
