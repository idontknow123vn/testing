package com.example.demo.entities;

import org.springframework.stereotype.Indexed;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "choose_many", indexes = {@Index(name = "idquizz_index", columnList = "idquizz")})
public class choose_many {
	@Column(name = "idquizz")
	private int idquizz;
	@Column(name = "answer")
	private String answer;
	@Column(name = "isRight")
	private boolean isRight;
	
	@OneToMany
	private quizz quizz;
	
	public choose_many() {
		
	}
	public choose_many(int idquizz, String answer, boolean isRight, quizz quizz) {
		this.idquizz = idquizz;
		this.answer = answer;
		this.isRight = isRight;
		this.quizz = quizz;
	}
}
