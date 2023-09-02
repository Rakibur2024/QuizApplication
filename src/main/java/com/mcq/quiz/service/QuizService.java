package com.mcq.quiz.service;

import com.mcq.quiz.entity.QuestionWrapper;
import com.mcq.quiz.entity.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    public ResponseEntity<String> createQuiz(String category, int numQ, String title);
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id);
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
