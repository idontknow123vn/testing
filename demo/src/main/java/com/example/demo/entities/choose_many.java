package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "choose_many")
public class choose_many {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idanswer")
	private int idanswer;
	@Column(name = "answer")
	private String answer;
	@Column(name = "isRight")
	private boolean isRight;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId
	@JoinColumn(name = "idquizz")
	private quizz quizz;
	
	public choose_many() {
		
	}

	public choose_many(int idanswer, String answer, boolean isRight, com.example.demo.entities.quizz quizz) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.isRight = isRight;
		this.quizz = quizz;
	}

	public int getIdanswer() {
		return idanswer;
	}

	public void setIdanswer(int idanswer) {
		this.idanswer = idanswer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public quizz getQuizz() {
		return quizz;
	}

	public void setQuizz(quizz quizz) {
		this.quizz = quizz;
	}
	
}
