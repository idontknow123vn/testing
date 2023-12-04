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
@Table(name = "writing")
public class writing_entity {
	@Id
	@Column(name = "idanswer")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idanswer;
	@Column(name = "answer")
	private String answer;
	@Column(name = "idquizz")
	private long idquizz;
	
	@ManyToOne
	@JoinColumn(name = "idquizz", insertable = false, updatable = false)
	@JsonBackReference
	private quizz_entity quizz;

	public writing_entity() {
		super();
	}

	public writing_entity(long idanswer, String answer, long idquizz, quizz_entity quizz) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.idquizz = idquizz;
		this.quizz = quizz;
	}

	public writing_entity(long idanswer, String answer, long idquizz) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.idquizz = idquizz;
	}
	public writing_entity(long idanswer, String answer) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
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
