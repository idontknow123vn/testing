package com.example.demo.service;

import com.example.demo.dto.normal_dto;

public interface normal_service {
	normal_dto getNormalStatById(long iduser);
	normal_dto createNormalStat(normal_dto statistic);
	normal_dto updateNormalStat(normal_dto statistic);
	void deleteNormalStat(long iduser);
}
