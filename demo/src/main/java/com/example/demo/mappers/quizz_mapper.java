package com.example.demo.mappers;

import java.util.Random;
import java.util.Base64;

import com.example.demo.dto.quizz_dto;
import com.example.demo.entities.quizz_entity;

public class quizz_mapper {
	private static Random rand = new Random();
	public static quizz_dto mapToQuizz_dto(quizz_entity entity) {
		quizz_dto dto = new quizz_dto(
				entity.getIdquizz(), 
				entity.getQuizz_info(), 
				(entity.getPicture() == null) ? null : Base64.getEncoder().encodeToString(entity.getPicture()), 
				entity.getSubject(), 
				entity.getDifficulty(), 
				entity.getTimeAnswered(), 
				entity.getChoose_one(), 
				entity.getWriting(), 
				entity.getChoose_many()
		);
		return dto;
	}
	public static quizz_entity mapToQuizz_entity(quizz_dto dto) {
		quizz_entity entity = new quizz_entity(
				dto.getIdquizz(), 
				dto.getQuizz_info(), 
				(dto.getPicture() == null) ? null : Base64.getDecoder().decode(dto.getPicture()), 
				dto.getSubject(), 
				dto.getDifficulty(), 
				dto.getTimeAnswered()
		);
		return entity;
	}
	public static quizz_dto mapToQuizz_dto_rand(quizz_entity entity) {
		quizz_dto dto = new quizz_dto(
				entity.getIdquizz(),
				entity.getQuizz_info(),
				(entity.getPicture() == null) ? null :Base64.getEncoder().encodeToString(entity.getPicture()),
				entity.getSubject(),
				entity.getDifficulty(),
				entity.getTimeAnswered());
		if(entity.getChoose_many().size() != 0 && entity.getWriting().size() != 0 && entity.getChoose_one() != null) {
			int num = rand.nextInt(3);
			if(num == 0) dto.setChoose_one(entity.getChoose_one());
			else if(num == 1) dto.setWriting(entity.getWriting());
			else dto.setChoose_many(entity.getChoose_many());
		}
		else if(entity.getChoose_many().size() == 0 && entity.getWriting().size() != 0 && entity.getChoose_one() != null) {
			int num = rand.nextInt(2);
			if(num == 0) dto.setChoose_one(entity.getChoose_one());
			else dto.setWriting(entity.getWriting());
		}
		else if (entity.getChoose_one() == null && entity.getChoose_many().size() != 0 && entity.getWriting().size() != 0) {
			int num = rand.nextInt(2);
			if(num == 0) dto.setChoose_many(entity.getChoose_many());
			else dto.setWriting(entity.getWriting());
		}
		else if (entity.getChoose_many().size() != 0 && entity.getWriting().size() == 0 && entity.getChoose_one() != null) {
			int num = rand.nextInt(2);
			if(num == 0) dto.setChoose_one(entity.getChoose_one());
			else dto.setChoose_many(entity.getChoose_many());
		}
		else {
			if(entity.getChoose_one() != null) dto.setChoose_one(entity.getChoose_one());
			else if(entity.getChoose_many().size() != 0)dto.setWriting(entity.getWriting());
			else if(entity.getWriting().size() != 0)dto.setChoose_many(entity.getChoose_many());
		}
		return dto;
	}
	public static quizz_entity mapToQuizz_entityFull(quizz_dto dto) {
		quizz_entity entity = new quizz_entity(
				dto.getIdquizz(), 
				dto.getQuizz_info(), 
				(dto.getPicture() == null) ? null :Base64.getDecoder().decode(dto.getPicture()), 
				dto.getSubject(), 
				dto.getDifficulty(), 
				dto.getTimeAnswered(),
				dto.getChoose_one(),
				null,
				null
		);
		if(entity.getChoose_one() != null) entity.getChoose_one().setQuizz(entity);
		return entity;
	}
}
