package com.example.demo.mappers;

import com.example.demo.dto.choose_one_dto;
import com.example.demo.entities.choose_one_entity;

public class choose_one_mapper {
	public static choose_one_dto mapToChoose_one_dto(choose_one_entity entity) {
		choose_one_dto dto = new choose_one_dto(
				entity.getIdquizz(), 
				entity.getRight_answer(), 
				entity.getWrong_answer1(), 
				entity.getWrong_answer2(), 
				entity.getWrong_answer3(),
				entity.getQuizz()
		);
		return dto;
	}
	public static choose_one_entity mapToChoose_one_entity(choose_one_dto dto) {
		choose_one_entity entity = new choose_one_entity(
				dto.getIdquizz(), 
				dto.getRight_answer(), 
				dto.getWrong_answer1(), 
				dto.getWrong_answer2(), 
				dto.getWrong_answer3()
		);
		return entity;
	}
}
