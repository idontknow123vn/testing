package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class account {
	@Id
	@Column(name = "Iduser")
	private int id;
	@Column(name = "Password")
	private String password;
	
	public account() {
		
	}
	
	public account(int id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getID() {
		return this.id;
	}
	public String getPassword() {
		return this.password;
	}
}
