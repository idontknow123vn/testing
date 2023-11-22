package com.example.demo.mappers;

import com.example.demo.dto.rank_dto;
import com.example.demo.entities.rank_entity;

public class rank_mapper {
	public static rank_dto mapToRank_dto(rank_entity _entity) {
		rank_dto _dto = new rank_dto(
				_entity.getIduser(),
				_entity.getRank(), 
				_entity.getPoint(),
				_entity.getGamePlayed(),
				_entity.getGameWon(),
				_entity.getUser()
		);
		return _dto;
	}
	public static rank_entity mapToRank_entity(rank_dto _dto) {
		rank_entity _entity = new rank_entity(
				_dto.getIduser(),
				_dto.getRank(), 
				_dto.getPoint(),
				_dto.getGamePlayed(),
				_dto.getGameWon()
		);
		return _entity;
	}
}
