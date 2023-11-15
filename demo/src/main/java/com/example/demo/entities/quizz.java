package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quizz")
public class quizz {
	@Id
	@Column(name = "idquizz")
	private int idquizz;
	@Column(name = "quizz_info")
	private String quizz_info;
	@Column(name = "picture")
	private byte[] picture;
	@Column(name = "subject")
	private String subject;
	@Column(name = "difficulties")
	private int difficulties;
	@Column(name = "timeAnswered")
	private int timeAnswered;
	
	public quizz() {
		
	}
	public quizz(int idquizz, String quizz_info, byte[] picture, String subject, int difficulties, int timeAnswered) {
		this.idquizz = idquizz;
		this.quizz_info = quizz_info;
		this.picture = picture;
		this.subject = subject;
		this.difficulties = difficulties;
		this.timeAnswered = timeAnswered;
	}
	public void setIdQuizz(int id) {
		this.idquizz = id;
	}
	public void setInfo(String quizz_info) {
		this.quizz_info = quizz_info;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setDifficulties(int difficulties) {
		this.difficulties = difficulties;
	}
	public void setTimeAnswered(int timeAnswered) {
		this.timeAnswered = timeAnswered;
	}
	public int getIdQuizz() {
		return this.idquizz;
	}
	public String getInfo() {
		return this.quizz_info;
	}
	public byte[] getPicture() {
		return this.picture;
	}
	public String getSubject() {
		return this.subject;
	}
	public int getDifficulties() {
		return this.difficulties;
	}
	public int getTimeAnswered() {
		return this.timeAnswered;
	}
}
