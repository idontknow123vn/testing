package com.example.demo.dto;

public class normal_statistics {
	private int id, gamePlayed, gameWon;
	
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
