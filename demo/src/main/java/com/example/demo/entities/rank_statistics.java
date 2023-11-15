package com.example.demo.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "rank_statistics")
public class rank_statistics extends normal_statistics {
	@Column(name = "rank")
	private String rank;
	@Column(name = "point")
	private int point;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user3", referencedColumnName = "iduser")
	private user user;
	
	public rank_statistics() {
		
	}
	public rank_statistics(int id, int gamePlayed, int gameWon, String rank, int point) {
		this.id = id;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
		this.rank = rank;
		this.point = point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void setPassword(String rank) {
		this.rank = rank;
	}
	public int getPoint() {
		return this.point;
	}
	public String getPassword() {
		return this.rank;
	}
}
