package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.rank_dto;
import com.example.demo.entities.rank_entity;
import com.example.demo.mappers.rank_mapper;
import com.example.demo.repository.rank_repos;
import com.example.demo.service.rank_service;

@Service
public class rank_service_impl implements rank_service {
	
	@Autowired
	private rank_repos rank_repos;

	@Override
	public rank_dto getRankStatById(long iduser) {
		// TODO Auto-generated method stub
		Optional<rank_entity> stat = rank_repos.findById(iduser);
		rank_dto dto = rank_mapper.mapToRank_dto(stat.get());
		return dto;
	}

	@Override
	public rank_dto createRankStat(rank_dto statistic) {
		// TODO Auto-generated method stub
		rank_entity entity = rank_mapper.mapToRank_entity(statistic);
		rank_entity savedEntity = rank_repos.save(entity);
		rank_dto savedDto = rank_mapper.mapToRank_dto(savedEntity);
		return savedDto;
	}

	@Override
	public rank_dto updateRankStat(rank_dto statistic) {
		// TODO Auto-generated method stub
		rank_entity exitingEntity = rank_repos.findById(statistic.getIduser()).get();
		exitingEntity.setGamePlayed(statistic.getGamePlayed());
		exitingEntity.setGameWon(statistic.getGameWon());
		exitingEntity.setRank(statistic.getRank());
		exitingEntity.setPoint(statistic.getPoint());
		rank_entity savedEntity = rank_repos.save(exitingEntity);
		return rank_mapper.mapToRank_dto(savedEntity);
	}

	@Override
	public void deleteRankStat(long iduser) {
		// TODO Auto-generated method stub
		rank_repos.deleteById(iduser);
	}

}
