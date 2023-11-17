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
	private user account;
	
	public normal_statistic(int id, int gamePlayed, int gameWon) {
		super();
		this.id = id;
		this.gamePlayed = gamePlayed;
		this.gameWon = gameWon;
	}
}
