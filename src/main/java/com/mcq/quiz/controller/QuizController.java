package com.mcq.quiz.controller;

import com.mcq.quiz.entity.Question;
import com.mcq.quiz.entity.QuestionWrapper;
import com.mcq.quiz.entity.Response;
import com.mcq.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numQ,
                                             @RequestParam String title){

        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);
    }

    @PostMapping("/submit/{quizid}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable("quizid") Integer id,
                                              @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

}
