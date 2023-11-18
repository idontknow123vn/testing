package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "writing")
public class writing_entity {
	@Id
	@Column(name = "idquizz")
	private int idquizz;
	@Column(name = "right_answer1")
	private String right_answer1;
	@Column(name = "right_answer2")
	private String right_answer2;
	@Column(name = "right_answer3")
	private String right_answer3;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "idquizz")
	private quizz_entity quizz;
	
	public writing_entity(int idquizz, String right_answer1, String right_answer2, String right_answer3) {
		super();
		this.idquizz = idquizz;
		this.right_answer1 = right_answer1;
		this.right_answer2 = right_answer2;
		this.right_answer3 = right_answer3;
	}
	public writing_entity() {
		
	}
	public writing_entity(int idquizz, String right_answer1, String right_answer2, String right_answer3,
			com.example.demo.entities.quizz_entity quizz) {
		super();
		this.idquizz = idquizz;
		this.right_answer1 = right_answer1;
		this.right_answer2 = right_answer2;
		this.right_answer3 = right_answer3;
		this.quizz = quizz;
	}
	public int getIdquizz() {
		return idquizz;
	}
	public void setIdquizz(int idquizz) {
		this.idquizz = idquizz;
	}
	public String getRight_answer1() {
		return right_answer1;
	}
	public void setRight_answer1(String right_answer1) {
		this.right_answer1 = right_answer1;
	}
	public String getRight_answer2() {
		return right_answer2;
	}
	public void setRight_answer2(String right_answer2) {
		this.right_answer2 = right_answer2;
	}
	public String getRight_answer3() {
		return right_answer3;
	}
	public void setRight_answer3(String right_answer3) {
		this.right_answer3 = right_answer3;
	}
	public quizz_entity getQuizz() {
		return quizz;
	}
	public void setQuizz(quizz_entity quizz) {
		this.quizz = quizz;
	}

}
