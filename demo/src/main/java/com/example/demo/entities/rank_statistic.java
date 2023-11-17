package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rank_statistic")
public class rank_statistic {
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
	private user account;

	public rank_statistic(int id, String rank, int point, int gamePlayed, int gameWon) {
		super();
		this.id = id;
		this.rank = rank;
		this.point = point;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
	}
}
