package com.example.demo.mappers;

import com.example.demo.dto.choose_many_dto;
import com.example.demo.entities.choose_many_entity;

public class choose_many_mapper {
	public static choose_many_dto mapToChoose_many_dto(choose_many_entity entity) {
		choose_many_dto dto = new choose_many_dto(
				entity.getIdanswer(), 
				entity.getAnswer(), 
				entity.isRight(),
				entity.getIdquizz()
		);
		return dto;
	}
	public static choose_many_entity mapToChoose_many_entity(choose_many_dto dto) {
		choose_many_entity entity = new choose_many_entity(
				dto.getIdanswer(),
				dto.getAnswer(),
				dto.isRight(), 
				dto.getIdquizz()
		);
		return entity;
	}
}
