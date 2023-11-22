package com.example.demo.mappers;

import com.example.demo.dto.writing_dto;
import com.example.demo.entities.writing_entity;

public class writing_mapper {
	public static writing_dto mapToWriting_dto(writing_entity entity) {
		writing_dto dto = new writing_dto(
				entity.getIdanswer(),
				entity.getAnswer(),
				entity.getIdquizz()
		);
		return dto;
	}
	public static writing_entity mapToWriting_entity(writing_dto dto) {
		writing_entity entity = new writing_entity(
				dto.getIdanswer(),
				dto.getAnswer(),
				dto.getIdquizz()
		);
		return entity;
	}
}
