package com.example.demo.dto;

public class writing_dto {
	private long idanswer;
	private String answer;
	private long idquizz;
	public writing_dto(long idanswer, String answer) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
	}
	public writing_dto() {
		super();
	}
	
	public writing_dto(long idanswer, String answer, long idquizz) {
		super();
		this.idanswer = idanswer;
		this.answer = answer;
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
	public long getIdquizz() {
		return idquizz;
	}
	public void setIdquizz(long idquizz) {
		this.idquizz = idquizz;
	}
}
