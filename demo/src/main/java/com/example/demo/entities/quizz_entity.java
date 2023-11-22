package com.example.demo.entities;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "quizz")
public class quizz_entity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idquizz")
	private long idquizz;
	@Column(name = "quizz_info")
	private String quizz_info;
	@Column(name = "picture")
	private byte[] picture;
	@Column(name = "subject")
	private String subject;
	@Column(name = "difficulty")
	private int difficulty;
	@Column(name = "timeAnswered")
	private int timeAnswered;
	
	@OneToOne(mappedBy = "quizz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonManagedReference
	private choose_one_entity choose_one;
	
	@OneToMany(mappedBy = "quizz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Collection<writing_entity> writing;
	
	@OneToMany(mappedBy = "quizz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Collection<choose_many_entity> choose_many;

	public quizz_entity(long idquizz, String quizz_info, byte[] picture, String subject, int difficulty, int timeAnswered) {
		super();
		this.idquizz = idquizz;
		this.quizz_info = quizz_info;
		this.picture = picture;
		this.subject = subject;
		this.difficulty = difficulty;
		this.timeAnswered = timeAnswered;
	}
	public quizz_entity() {
		
	}
	public quizz_entity(long idquizz, String quizz_info, byte[] picture, String subject, int difficulty, int timeAnswered,
			com.example.demo.entities.choose_one_entity choose_one, Collection<com.example.demo.entities.writing_entity> writing,
			Collection<com.example.demo.entities.choose_many_entity> choose_many) {
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
		if(choose_one == null) {
			if(this.choose_one != null) {
				this.choose_one.setQuizz(null);
			}
		}
		else {
			choose_one.setQuizz(this);
		}
		this.choose_one = choose_one;
	}
	public Collection<choose_many_entity> getChoose_many() {
		return choose_many;
	}
	public void setChoose_many(Collection<choose_many_entity> choose_many) {
		this.choose_many = choose_many;
	}
	public Collection<writing_entity> getWriting() {
		return writing;
	}
	public void setWriting(Collection<writing_entity> writing) {
		this.writing = writing;
	}
	
}
