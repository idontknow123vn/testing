package com.example.demo.dto;

public class account {
	private int id;
	private String password;
	
	public account() {
		
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
