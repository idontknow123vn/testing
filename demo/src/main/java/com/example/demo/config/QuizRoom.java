package com.example.demo.config;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.quizz_dto;
import com.example.demo.dto.user_dto;

public class QuizRoom {
    private String name;
    private Map<String, Double> playersPoints;
    private int number;
    public QuizRoom(String name, Map<String, Double> playersPoints, int number) {
		super();
		this.name = name;
		this.playersPoints = playersPoints;
		this.number = number;
	}
    public Map<String, Double> getPlayersPoints() {
		return playersPoints;
	}
	public void setPlayersPoints(Map<String, Double> playersPoints) {
		this.playersPoints = playersPoints;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}