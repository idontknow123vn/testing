package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "writing")
public class writing {
	@Id
	@Column(name = "idquizz")
	private int idquizz;
	@Column(name = "right_answer1")
	private String right_answer1;
	@Column(name = "right_answer2")
	private String right_answer2;
	@Column(name = "right_answer3")
	private String right_answer3;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_quizz2", referencedColumnName = "idquizz")
	private quizz quizz;
	
	public writing() {
		
	}
	public writing(int idquizz, String right_answer1, String right_answer2, String right_answer3, quizz quizz) {
		this.idquizz = idquizz;
		this.right_answer1 = right_answer1;
		this.right_answer2 = right_answer2;
		this.right_answer3 = right_answer3;
		this.quizz = quizz;
	}
}
