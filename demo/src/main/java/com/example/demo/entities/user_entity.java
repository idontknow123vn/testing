package com.example.demo.entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class user_entity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iduser")
	private long iduser;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "username")
	private String username;
	@Column(name = "gender")
	private boolean gender;
	@Column(name = "dateCreated")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreated;
	@Column(name = "status")
	private boolean status;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonManagedReference
	private normal_entity normal_statistic;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonManagedReference
	private rank_entity rank_statistic;
	
	public user_entity() {
		
	}
	
	public user_entity(long iduser, String password, String name, String username, boolean gender, Date dateCreated, boolean status) {
		super();
		this.iduser = iduser;
		this.password = password;
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.dateCreated = dateCreated;
		this.status = status;
	}

	public user_entity(long iduser, String password, String name, String username, boolean gender, Date dateCreated, boolean status,
			com.example.demo.entities.normal_entity normal_statistic,
			com.example.demo.entities.rank_entity rank_statistic) {
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

	public normal_entity getNormal_statistic() {
		return normal_statistic;
	}

	public void setNormal_statistic(normal_entity normal_statistic) {
		if(normal_statistic == null) {
			if(this.normal_statistic != null) {
				this.normal_statistic.setUser(null);
			}
		}
		else {
			normal_statistic.setUser(this);
		}
		this.normal_statistic = normal_statistic;
	}

	public rank_entity getRank_statistic() {
		return rank_statistic;
	}

	public void setRank_statistic(rank_entity rank_statistic) {
		if(rank_statistic == null) {
			if(this.rank_statistic != null) {
				this.rank_statistic.setUser(null);
			}
		}
		else {
			rank_statistic.setUser(this);
		}
		this.rank_statistic = rank_statistic;
	}
	
}
