package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "choose_many")
public class choose_many_entity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idanswer")
	private int idanswer;
	@Column(name = "answer")
	private String answer;
	@Column(name = "isRight")
	private boolean isRight;
	@Column(name = "idquizz")
	private int idquizz;

	public choose_many_entity(int idanswer, String answer, boolean isRight) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.isRight = isRight;
	}
	public choose_many_entity() {
		
	}
	public choose_many_entity(int idanswer, String answer, boolean isRight, com.example.demo.entities.quizz_entity quizz) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.isRight = isRight;
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
//	public quizz_entity getQuizz() {
//		return quizz;
//	}
//	public void setQuizz(quizz_entity quizz) {
//		this.quizz = quizz;
//	}
	
}
