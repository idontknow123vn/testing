package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "choose_many")
public class choose_many_entity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idanswer")
	private long idanswer;
	@Column(name = "answer")
	private String answer;
	@Column(name = "isRight")
	private boolean isRight;
	@Column(name = "idquizz")
	private long idquizz;
	
	@ManyToOne
	@JoinColumn(name = "idquizz", insertable = false, updatable = false)
	@JsonBackReference
	private quizz_entity quizz;

	public choose_many_entity(long idanswer, String answer, boolean isRight, long idquizz) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.isRight = isRight;
		this.idquizz = idquizz;
	}
	public choose_many_entity() {
		
	}
	
	public choose_many_entity(long idanswer, String answer, boolean isRight) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.isRight = isRight;
	}
	public choose_many_entity(long idanswer, String answer, boolean isRight, long idquizz, com.example.demo.entities.quizz_entity quizz) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.isRight = isRight;
		this.idquizz = idquizz;
		this.quizz = quizz;
	}
	public long getIdanswer() {
		return idanswer;
	}
	public void setIdanswer(long idanswer) {
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
	public long getIdquizz() {
		return idquizz;
	}
	public void setIdquizz(long idquizz) {
		this.idquizz = idquizz;
	}
	public quizz_entity getQuizz() {
		return quizz;
	}
	public void setQuizz(quizz_entity quizz) {
		this.quizz = quizz;
	}
	
}
