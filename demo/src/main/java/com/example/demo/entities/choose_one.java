package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "choose_one")
public class choose_one {
	@Id
	@Column(name = "idquizz")
	private int idquizz;
	@Column(name = "right_answer")
	private String right_answer;
	@Column(name = "wrong_answer1")
	private String wrong_answer1;
	@Column(name = "wrong_answer2")
	private String wrong_answer2;
	@Column(name = "wrong_answer3")
	private String wrong_answer3;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_quizz1", referencedColumnName = "idquizz")
	private quizz quizz;
	
	public choose_one() {
		
	}
	
	public choose_one(int idquizz, String right_answer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, quizz quizz) {
		this.idquizz = idquizz;
		this.right_answer = right_answer;
		this.wrong_answer1 = wrongAnswer1;
		this.wrong_answer2 = wrongAnswer2;
		this.wrong_answer3 = wrongAnswer3;
		this.quizz = quizz;
	}

}