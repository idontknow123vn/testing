package com.example.demo.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "idquizz")
	private quizz quizz;
	
	public choose_one(int idquizz, String right_answer, String wrong_answer1, String wrong_answer2,
			String wrong_answer3) {
		super();
		this.idquizz = idquizz;
		this.right_answer = right_answer;
		this.wrong_answer1 = wrong_answer1;
		this.wrong_answer2 = wrong_answer2;
		this.wrong_answer3 = wrong_answer3;
	}
}