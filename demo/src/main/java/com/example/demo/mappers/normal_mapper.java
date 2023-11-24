package com.example.demo.mappers;

import com.example.demo.dto.normal_dto;
import com.example.demo.entities.normal_entity;

public class normal_mapper {
	public static normal_dto mapToNormal_dto(normal_entity entity) {
		normal_dto normal_dto = new normal_dto(
				entity.getIduser(), 
				entity.getGamePlayed(), 
				entity.getGameWon(),
				entity.getUser()
		);
		return normal_dto;
	}
	public static normal_entity mapToNormal_entity(normal_dto dto) {
		normal_entity entity = new normal_entity(
				dto.getIduser(),
				dto.getGamePlayed(),
				dto.getGameWon()
		);
		return entity;
	}
}
