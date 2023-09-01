package com.mcq.quiz.service;

import com.mcq.quiz.dao.QuestionDao;
import com.mcq.quiz.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionDao questionDao;

    @Override
    public List<Question> questionList(){
        return questionDao.findAll();
    }

    @Override
    public List<Question> questionListByCategory(String category){
        return questionDao.findByCategory(category);
    }

    @Override
    public Question addQuestion(@RequestBody Question question){
        return questionDao.save(question);
    }
}
