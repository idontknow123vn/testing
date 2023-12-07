package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.quizz_dto;

public interface quizz_service {
	quizz_dto createQuizz(quizz_dto dto);
	quizz_dto getQuizzById(long idquizz);
	List<quizz_dto> getAllQuizz();
	List<quizz_dto> generateQuizz();
	quizz_dto updateQuizz(quizz_dto dto);
	void deleteQuizz(long idquizz);
}
