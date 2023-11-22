package com.example.demo.dto;

public class choose_many_dto {
	private long idanswer;
	private String answer;
	private boolean isRight;
	private long idquizz;
	public choose_many_dto(long idanswer, String answer, boolean isRight) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.isRight = isRight;
	}
	public choose_many_dto() {
		super();
	}
	public choose_many_dto(long idanswer, String answer, boolean isRight, long idquizz) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
		this.isRight = isRight;
		this.idquizz = idquizz;
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
}
