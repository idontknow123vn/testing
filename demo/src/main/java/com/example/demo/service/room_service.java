package com.example.demo.service;

import java.util.List;

import com.example.demo.config.QuizRoom;
import com.example.demo.dto.quizz_dto;
import com.example.demo.dto.user_dto;

public interface room_service {
	user_dto addUserToRoom(QuizRoom room, user_dto dto);
	List<quizz_dto> generateQuestion();
	user_dto findUserInRoom(QuizRoom room);
}
