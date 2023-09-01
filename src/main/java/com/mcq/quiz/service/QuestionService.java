package com.mcq.quiz.service;

import com.mcq.quiz.entity.Question;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface QuestionService {
    public List<Question> questionList();

    public List<Question> questionListByCategory(String category);

    public Question addQuestion(@RequestBody Question question);
}
