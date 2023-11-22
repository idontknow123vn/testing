package com.example.demo.mappers;

import com.example.demo.dto.quizz_dto;
import com.example.demo.entities.quizz_entity;

public class quizz_mapper {
	public static quizz_dto mapToQuizz_dto(quizz_entity entity) {
		quizz_dto dto = new quizz_dto(
				entity.getIdquizz(), 
				entity.getQuizz_info(), 
				entity.getPicture(), 
				entity.getSubject(), 
				entity.getDifficulty(), 
				entity.getTimeAnswered(), 
				entity.getChoose_one(), 
				entity.getWriting(), 
				entity.getChoose_many()
		);
		return dto;
	}
	public static quizz_entity mapToQuizz_entity(quizz_dto dto) {
		quizz_entity entity = new quizz_entity(
				dto.getIdquizz(), 
				dto.getQuizz_info(), 
				dto.getPicture(), 
				dto.getSubject(), 
				dto.getDifficulty(), 
				dto.getTimeAnswered()
		);
		return entity;
	}
}
