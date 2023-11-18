package com.example.demo.entities;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "quizz")
public class quizz_entity {
	@Id
	@Column(name = "idquizz")
	private int idquizz;
	@Column(name = "quizz_info")
	private String quizz_info;
	@Column(name = "picture")
	private byte[] picture;
	@Column(name = "subject")
	private String subject;
	@Column(name = "difficulties")
	private int difficulties;
	@Column(name = "timeAnswered")
	private int timeAnswered;
	
	@OneToOne(mappedBy = "quizz", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private choose_one_entity choose_one;
	
	@OneToOne(mappedBy = "quizz", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private writing_entity writing;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idquizz", referencedColumnName = "idquizz")
	private Collection<choose_many_entity> choose_many;

	public quizz_entity(int idquizz, String quizz_info, byte[] picture, String subject, int difficulties, int timeAnswered) {
		super();
		this.idquizz = idquizz;
		this.quizz_info = quizz_info;
		this.picture = picture;
		this.subject = subject;
		this.difficulties = difficulties;
		this.timeAnswered = timeAnswered;
	}
	public quizz_entity() {
		
	}
	public quizz_entity(int idquizz, String quizz_info, byte[] picture, String subject, int difficulties, int timeAnswered,
			com.example.demo.entities.choose_one_entity choose_one, com.example.demo.entities.writing_entity writing,
			Collection<com.example.demo.entities.choose_many_entity> choose_many) {
		super();
		this.idquizz = idquizz;
		this.quizz_info = quizz_info;
		this.picture = picture;
		this.subject = subject;
		this.difficulties = difficulties;
		this.timeAnswered = timeAnswered;
		this.choose_one = choose_one;
		this.writing = writing;
		this.choose_many = choose_many;
	}
	public int getIdquizz() {
		return idquizz;
	}
	public void setIdquizz(int idquizz) {
		this.idquizz = idquizz;
	}
	public String getQuizz_info() {
		return quizz_info;
	}
	public void setQuizz_info(String quizz_info) {
		this.quizz_info = quizz_info;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getDifficulties() {
		return difficulties;
	}
	public void setDifficulties(int difficulties) {
		this.difficulties = difficulties;
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
	public writing_entity getWriting() {
		return writing;
	}
	public void setWriting(writing_entity writing) {
		this.writing = writing;
	}
	public Collection<choose_many_entity> getChoose_many() {
		return choose_many;
	}
	public void setChoose_many(Collection<choose_many_entity> choose_many) {
		this.choose_many = choose_many;
	}
	
}
