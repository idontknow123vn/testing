package com.example.demo.entities;

import java.sql.Date;

public class user {
	private int id;
	private String name;
	private boolean gender;
	private Date createdDate;
	private boolean status;
	
	public user() {
		
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
		this.createdDate = date;
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
		return this.createdDate;
	}
	public boolean getStatus() {
		return this.status;
	}
}
