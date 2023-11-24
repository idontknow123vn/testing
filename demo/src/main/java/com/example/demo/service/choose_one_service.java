package com.example.demo.service;

import com.example.demo.dto.choose_one_dto;

public interface choose_one_service {
	choose_one_dto createAnswer(choose_one_dto dto);
	choose_one_dto getAnswer(long idquizz);
	choose_one_dto updateAnswer(choose_one_dto dto);
	void deleteAnswer(long idquizz);
}
