package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.choose_many_dto;

public interface choose_many_service {
	choose_many_dto createAnswer(choose_many_dto dto);
	choose_many_dto getAnswerByIdanswer(long idanswer);
	List<choose_many_dto> getListAnswerByIdquizz(long idquizz);
	choose_many_dto updateAnswer(choose_many_dto dto);
	void deleteAnswer(long idanswer);
}
