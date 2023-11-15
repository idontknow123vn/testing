package com.example.demo.entities;

public class rank_statistics extends normal_statistics {
	private String rank;
	private int point;
	public rank_statistics() {
		
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
