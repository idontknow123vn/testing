package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rank_statistic")
public class rank_entity {
	@Id
	@Column(name = "iduser")
	private long iduser;
	@Column(name = "rank")
	private String rank;
	@Column(name = "point")
	private int point;
	@Column(name = "gamePlayed")
	private int gamePlayed;
	@Column(name = "gameWon")
	private int gameWon;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "iduser")
	@JsonBackReference
	private user_entity user;

	public rank_entity(long id, String rank, int point, int gamePlayed, int gameWon) {
		super();
		this.iduser = id;
		this.rank = rank;
		this.point = point;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
	}
	public rank_entity() {
		
	}
	public rank_entity(long id, String rank, int point, int gamePlayed, int gameWon, user_entity user) {
		super();
		this.iduser = id;
		this.rank = rank;
		this.point = point;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
		this.user = user;
	}
	public long getIduser() {
		return iduser;
	}
	public void setIduser(long id) {
		this.iduser = id;
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
	public user_entity getUser() {
		return user;
	}
	public void setUser(user_entity user) {
		this.user = user;
	}
	
}
