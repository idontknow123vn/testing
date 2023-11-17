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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	@ManyToOne
	@MapsId
	@JoinColumn(name = "idquizz")
	private quizz quizz;

	public choose_many(int idanswer, String answer, boolean isRight) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.isRight = isRight;
	}
}
