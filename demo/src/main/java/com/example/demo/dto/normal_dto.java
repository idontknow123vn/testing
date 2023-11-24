package com.example.demo.dto;

import com.example.demo.entities.user_entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "null")
public class normal_dto {
	private long iduser;
	private int gamePlayed;
	private int gameWon;
	@JsonIgnore
	private user_entity user_entity;
	public normal_dto(long iduser, int gamePlayed, int gameWon,
			com.example.demo.entities.user_entity user_entity) {
		super();
		this.iduser = iduser;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
		this.user_entity = user_entity;
	}
	public normal_dto(long iduser, int gamePlayed, int gameWon) {
		super();
		this.iduser = iduser;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
	}
	public normal_dto() {
		
	}
	public long getIduser() {
		return iduser;
	}
	public void setIduser(long iduser) {
		this.iduser = iduser;
	}
	public int getGamePlayed() {
		return gamePlayed;
	}
	public void setGamePlayed(int gamePlayed) {
		this.gamePlayed = gamePlayed;
	}
	public int getGameWon() {
		return gameWon;
	}
	public void setGameWon(int gameWon) {
		this.gameWon = gameWon;
	}
	public user_entity getUser_entity() {
		return user_entity;
	}
	public void setUser_entity(user_entity user_entity) {
		this.user_entity = user_entity;
	}
	
}
