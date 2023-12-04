package com.example.demo.dto;

import com.example.demo.entities.quizz_entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "null")
public class choose_one_dto {
	private long idquizz;
	private String right_answer;
	private String wrong_answer1;
	private String wrong_answer2;
	private String wrong_answer3;
	@JsonIgnore
	private quizz_entity quizz;
	public choose_one_dto(long idquizz, String right_answer, String wrong_answer1, String wrong_answer2,
			String wrong_answer3, quizz_entity quizz) {
		super();
		this.idquizz = idquizz;
		this.right_answer = right_answer;
		this.wrong_answer1 = wrong_answer1;
		this.wrong_answer2 = wrong_answer2;
		this.wrong_answer3 = wrong_answer3;
		this.quizz = quizz;
	}
	public choose_one_dto(long idquizz, String right_answer, String wrong_answer1, String wrong_answer2,
			String wrong_answer3) {
		super();
		this.idquizz = idquizz;
		this.right_answer = right_answer;
		this.wrong_answer1 = wrong_answer1;
		this.wrong_answer2 = wrong_answer2;
		this.wrong_answer3 = wrong_answer3;
	}
	public choose_one_dto() {
		
	}
	public long getIdquizz() {
		return idquizz;
	}
	public void setIdquizz(long idquizz) {
		this.idquizz = idquizz;
	}
	public String getRight_answer() {
		return right_answer;
	}
	public void setRight_answer(String right_answer) {
		this.right_answer = right_answer;
	}
	public String getWrong_answer1() {
		return wrong_answer1;
	}
	public void setWrong_answer1(String wrong_answer1) {
		this.wrong_answer1 = wrong_answer1;
	}
	public String getWrong_answer2() {
		return wrong_answer2;
	}
	public void setWrong_answer2(String wrong_answer2) {
		this.wrong_answer2 = wrong_answer2;
	}
	public String getWrong_answer3() {
		return wrong_answer3;
	}
	public void setWrong_answer3(String wrong_answer3) {
		this.wrong_answer3 = wrong_answer3;
	}
	public quizz_entity getQuizz() {
		return quizz;
	}
	public void setQuizz(quizz_entity quizz) {
		this.quizz = quizz;
	}
	
}
