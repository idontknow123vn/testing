package com.example.demo.entities;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "user")
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser")
	private int iduser;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "gender")
	private boolean gender;
	@Column(name = "dateCreated")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreated;
	@Column(name = "status")
	private boolean status;
	
	@OneToOne(mappedBy = "account")
	@PrimaryKeyJoinColumn
	private normal_statistic normal_statistic;
	
	@OneToOne(mappedBy = "account")
	@PrimaryKeyJoinColumn
	private rank_statistic rank_statistic;
	
	public user(int iduser, String password, String name, boolean gender, Date dateCreated, boolean status) {
		super();
		this.iduser = iduser;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.dateCreated = dateCreated;
		this.status = status;
	}
}
