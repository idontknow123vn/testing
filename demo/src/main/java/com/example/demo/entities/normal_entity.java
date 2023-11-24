package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "normal_statistic")
public class normal_entity {
	@Id
	@Column(name = "iduser")
	private long iduser;
	
	@Column(name = "gamePlayed")
	private int gamePlayed;
	
	@Column(name = "gameWon")
	private int gameWon;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "iduser")
	@JsonBackReference
	private user_entity user;
	
	public normal_entity(long iduser, int gamePlayed, int gameWon) {
		super();
		this.iduser = iduser;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
	}
	
	public normal_entity() {
		
	}

	public normal_entity(long id, int gamePlayed, int gameWon, com.example.demo.entities.user_entity user) {
		super();
		this.iduser = id;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
		this.user = user;
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

	public user_entity getUser() {
		return user;
	}

	public void setUser(user_entity user) {
		this.user = user;
	}
	
}
