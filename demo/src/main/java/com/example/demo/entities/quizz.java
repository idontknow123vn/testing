package com.example.demo.entities;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "quizz")
public class quizz {
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
	private choose_one choose_one;
	
	@OneToOne(mappedBy = "quizz", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private writing writing;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<choose_many> choose_many;

	public quizz(int idquizz, String quizz_info, byte[] picture, String subject, int difficulties, int timeAnswered) {
		super();
		this.idquizz = idquizz;
		this.quizz_info = quizz_info;
		this.picture = picture;
		this.subject = subject;
		this.difficulties = difficulties;
		this.timeAnswered = timeAnswered;
	}

}
