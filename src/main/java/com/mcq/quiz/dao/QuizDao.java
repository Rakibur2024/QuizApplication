package com.mcq.quiz.dao;

import com.mcq.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
