package com.mcq.quiz.service;

import com.mcq.quiz.dao.QuestionDao;
import com.mcq.quiz.dao.QuizDao;
import com.mcq.quiz.entity.Question;
import com.mcq.quiz.entity.QuestionWrapper;
import com.mcq.quiz.entity.Quiz;
import com.mcq.quiz.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    @Override
    public ResponseEntity<String> createQuiz(String category, int numQ, String title){

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id){
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();

        List<QuestionWrapper> questionsForUsers = new ArrayList<>();
        for (Question q : questionsFromDB ){
            QuestionWrapper qu = new QuestionWrapper(
                                                        q.getId(),q.getQuestionTitle(),q.getOption1(),
                                                        q.getOption2(),q.getOption3(),q.getOption4()
                                                    );
            questionsForUsers.add(qu);
        }

        return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses){
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;
        for (Response response : responses){
            if (response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }

}
