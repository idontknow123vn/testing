package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "normal_statistic")
public class normal_statistic {
	@Id
	@Column(name = "iduser")
	private int id;
	@Column(name = "gamePlayed")
	private int gamePlayed;
	@Column(name = "gameWon")
	private int gameWon;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "iduser")
	private account account;
	
	public normal_statistic() {
		
	}
	
	public normal_statistic(int id, int gamePlayed, int gameWon) {
		super();
		this.id = id;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public account getAccount() {
		return account;
	}

	public void setAccount(account account) {
		this.account = account;
	}
	
}
