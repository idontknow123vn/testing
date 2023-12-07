package com.example.demo.mappers;

import com.example.demo.dto.user_dto;
import com.example.demo.entities.user_entity;

public class user_mapper {
	public static user_dto mapToUser_dto(user_entity user_entity) {
		if(user_entity == null) return null;
		else {
			user_dto user_dto = new user_dto(
					user_entity.getIduser(), 
					user_entity.getPassword(), 
					user_entity.getName(),
					user_entity.getUsername(),
					user_entity.isGender(), 
					user_entity.getDateCreated(), 
					user_entity.isStatus(),
					user_entity.getNormal_statistic(),
					user_entity.getRank_statistic()
			);
			return user_dto;
		}
	}
	public static user_dto mapIncompleteToUser_dto(user_entity entity) {
		user_dto dto = new user_dto();
		dto.setIduser(entity.getIduser());
		dto.setName(entity.getName());
		dto.setNormal_statistic(entity.getNormal_statistic());
		dto.setRank_statistic(entity.getRank_statistic());
		return dto;
	}
	public static user_entity mapToUser_entity(user_dto user_dto) {
		user_entity user_entity = new user_entity(
				user_dto.getIduser(),
				user_dto.getPassword(),
				user_dto.getName(),
				user_dto.getUsername(),
				user_dto.isGender(),
				user_dto.getDateCreated(),
				user_dto.isStatus()
		);
		return user_entity;
	}
}
