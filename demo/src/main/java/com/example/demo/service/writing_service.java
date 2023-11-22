package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.writing_dto;

public interface writing_service {
	writing_dto createAnswer(writing_dto dto);
	writing_dto getAnswerByIdanswer(long idanswer);
	List<writing_dto> getListAnswerByIdquizz(long idquizz);
	writing_dto updateAnswer(writing_dto dto);
	void deleteAnswer(long idanswer);
}
