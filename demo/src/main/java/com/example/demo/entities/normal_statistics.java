package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "normal_statistics")
public class normal_statistics {
	@Id
	@Column(name = "iduser")
	protected int id;
	@Column(name = "gamePlayed")
	protected int gamePlayed;
	@Column(name = "gameWon")
	protected int gameWon;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user2", referencedColumnName = "iduser")
	private user user;
	
	public normal_statistics() {
		
	}
	
	public void setID(int id) {
		this.id = id;
	}
	public void setGamePlayed(int gamePlayed) {
		this.gamePlayed = gamePlayed;
	}
	public void setGameWon(int gameWon) {
		this.gameWon = gameWon;
	}
	public int getID() {
		return this.id;
	}
	public int getGamePlayed() {
		return this.gamePlayed;
	}
	public int getGameWon() {
		return this.gameWon;
	}
	
}
