package com.example.demo.entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser")
	private int iduser;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "gender")
	private boolean gender;
	@Column(name = "dateCreated")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreated;
	@Column(name = "status")
	private boolean status;
	
	@OneToOne(mappedBy = "account")
	@PrimaryKeyJoinColumn
	private normal_statistic normal_statistic;
	
	@OneToOne(mappedBy = "account")
	@PrimaryKeyJoinColumn
	private rank_statistic rank_statistic;
	
	public account() {
		
	}
	
	public account(int iduser, String password, String name, boolean gender, Date dateCreated, boolean status) {
		super();
		this.iduser = iduser;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.dateCreated = dateCreated;
		this.status = status;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
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

	public normal_statistic getNormal_statistics() {
		return normal_statistic;
	}

	public void setNormal_statistics(normal_statistic normal_statistics) {
		this.normal_statistic = normal_statistics;
	}

	public rank_statistic getRank_statistics() {
		return rank_statistic;
	}

	public void setRank_statistics(rank_statistic rank_statistics) {
		this.rank_statistic = rank_statistics;
	}
}
