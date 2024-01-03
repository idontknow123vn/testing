package com.example.demo.dto;

import java.util.Collection;

import com.example.demo.entities.choose_many_entity;
import com.example.demo.entities.choose_one_entity;
import com.example.demo.entities.writing_entity;
import com.fasterxml.jackson.annotation.JsonRootName;

public class quizz_dto {
	private long idquizz;
	private String quizz_info;
	private String picture;
	private String subject;
	private int difficulty;
	private int timeAnswered;
	private choose_one_entity choose_one;
	private Collection<writing_entity> writing;
	private Collection<choose_many_entity> choose_many;
	
	public quizz_dto() {
		
	}

	public quizz_dto(long idquizz, String quizz_info, String picture, String subject, int difficulty, int timeAnswered,
			choose_one_entity choose_one, Collection<writing_entity> writing, Collection<choose_many_entity> choose_many) {
		super();
		this.idquizz = idquizz;
		this.quizz_info = quizz_info;
		this.picture = picture;
		this.subject = subject;
		this.difficulty = difficulty;
		this.timeAnswered = timeAnswered;
		this.choose_one = choose_one;
		this.writing = writing;
		this.choose_many = choose_many;
	}

	public quizz_dto(long idquizz, String quizz_info, String picture, String subject, int difficulty,
			int timeAnswered) {
		super();
		this.idquizz = idquizz;
		this.quizz_info = quizz_info;
		this.picture = picture;
		this.subject = subject;
		this.difficulty = difficulty;
		this.timeAnswered = timeAnswered;
	}

	public long getIdquizz() {
		return idquizz;
	}

	public void setIdquizz(long idquizz) {
		this.idquizz = idquizz;
	}

	public String getQuizz_info() {
		return quizz_info;
	}

	public void setQuizz_info(String quizz_info) {
		this.quizz_info = quizz_info;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getTimeAnswered() {
		return timeAnswered;
	}

	public void setTimeAnswered(int timeAnswered) {
		this.timeAnswered = timeAnswered;
	}

	public choose_one_entity getChoose_one() {
		return choose_one;
	}

	public void setChoose_one(choose_one_entity choose_one) {
		this.choose_one = choose_one;
	}

	public Collection<writing_entity> getWriting() {
		return writing;
	}

	public void setWriting(Collection<writing_entity> writing) {
		this.writing = writing;
	}

	public Collection<choose_many_entity> getChoose_many() {
		return choose_many;
	}

	public void setChoose_many(Collection<choose_many_entity> choose_many) {
		this.choose_many = choose_many;
	}
	
}