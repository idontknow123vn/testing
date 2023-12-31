package com.example.demo.config;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.quizz_dto;
import com.example.demo.dto.user_dto;

public class QuizRoom {
    private String name;
    private Map<String, Double> playersPoints;
    private int number;
    private int numberSubmitted;
    private String host;
    public QuizRoom() {
		// TODO Auto-generated constructor stub
    	super();
	}
    public QuizRoom(String name, Map<String, Double> playersPoints, int number, int numberSubmitted, String host) {
		super();
		this.name = name;
		this.playersPoints = playersPoints;
		this.number = number;
		this.numberSubmitted = numberSubmitted;
		this.host = host;
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
	public int getNumberSubmitted() {
		return numberSubmitted;
	}
	public void setNumberSubmitted(int numberSubmitted) {
		this.numberSubmitted = numberSubmitted;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void addUser(String user) {
		this.playersPoints.put(user, 0.0);
	}
	public void removeUser(String user) {
		if(this.playersPoints.containsKey(user)) this.playersPoints.remove(user);
	}
	public void changeHost() {
		if (playersPoints != null && !playersPoints.isEmpty()) {
            this.host = playersPoints.keySet().iterator().next();
        }
	}
}