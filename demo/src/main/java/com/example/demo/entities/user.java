package com.example.demo.entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class user {
	@Id
	@Column(name = "iduser")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "gender")
	private boolean gender;
	@Column(name = "dateCreated")
	private Date dateCreated;
	@Column(name = "status")
	private boolean status;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user1", referencedColumnName = "iduser")
	private account account;
	
	public user() {
		
	}
	public user(int id, String name, boolean gender, Date date, boolean status) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateCreated = date;
		this.status = status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public void setDate(Date date) {
		this.dateCreated = date;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public boolean getGender() {
		return this.gender;
	}
	public Date getDate() {
		return this.dateCreated;
	}
	public boolean getStatus() {
		return this.status;
	}
}
