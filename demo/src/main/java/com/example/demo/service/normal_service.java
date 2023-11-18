package com.example.demo.service;

import com.example.demo.dto.normal_dto;

public interface normal_service {
	normal_dto getNormalStatisticById(int iduser);
	normal_dto createNormal_statistic(normal_dto statistic);
	normal_dto updateNormal_statistic(normal_dto statistic);
	void deleteNormal_statistic(int iduser);
}
