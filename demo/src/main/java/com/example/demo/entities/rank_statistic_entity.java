package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rank_statistic")
public class rank_statistic_entity {
	@Id
	@Column(name = "iduser")
	protected int id;
	@Column(name = "rank")
	private String rank;
	@Column(name = "point")
	private int point;
	@Column(name = "gamePlayed")
	private int gamePlayed;
	@Column(name = "gameWon")
	private int gameWon;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "iduser")
	private user_entity user;

	public rank_statistic_entity(int id, String rank, int point, int gamePlayed, int gameWon) {
		super();
		this.id = id;
		this.rank = rank;
		this.point = point;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
	}
	public rank_statistic_entity() {
		
	}
	public rank_statistic_entity(int id, String rank, int point, int gamePlayed, int gameWon, user_entity user) {
		super();
		this.id = id;
		this.rank = rank;
		this.point = point;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
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
	public user_entity getAccount() {
		return user;
	}
	public void setAccount(user_entity user) {
		this.user = user;
	}
	
}
