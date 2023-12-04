package com.example.demo.service;

import com.example.demo.dto.rank_dto;

public interface rank_service {
	rank_dto getRankStatById(long iduser);
	rank_dto createRankStat(rank_dto statistic);
	rank_dto updateRankStat(rank_dto statistic);
	void deleteRankStat(long iduser);
}
