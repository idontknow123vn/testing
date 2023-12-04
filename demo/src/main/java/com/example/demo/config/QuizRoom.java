package com.example.demo.config;

import java.util.List;
import java.util.Map;

import com.example.demo.dto.quizz_dto;
import com.example.demo.dto.user_dto;

public class QuizRoom {
    private String name;
    private Map<user_dto, Integer> players;
    private List<quizz_dto> questions;
    private int roomsize;
	public QuizRoom(String name, Map<user_dto, Integer> players, List<quizz_dto> questions, int roomSize) {
		super();
		this.name = name;
		this.players = players;
		this.questions = questions;
		this.roomsize = roomSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<user_dto, Integer> getPlayers() {
		return players;
	}
	public void setPlayers(Map<user_dto, Integer> players) {
		this.players = players;
	}
	public List<quizz_dto> getQuestions() {
		return questions;
	}
	public void setQuestions(List<quizz_dto> questions) {
		this.questions = questions;
	}
	public int getRoomsize() {
		return roomsize;
	}
	public void setRoomsize(int roomsize) {
		this.roomsize = roomsize;
	}
	public void addPoint(user_dto player) {
	    int currentScore = players.getOrDefault(player, 0);
	    players.put(player, currentScore + 1);
	}
	public user_dto determineWinner() {
	    return players.entrySet().stream()
	        .max(Map.Entry.comparingByValue())
	        .map(Map.Entry::getKey)
	        .orElse(null);
	}
}
