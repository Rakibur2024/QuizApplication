package com.mcq.quiz.controller;

import com.mcq.quiz.entity.Question;
import com.mcq.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

   @Autowired
   QuestionService questionService;

   @GetMapping("/list")
   public ResponseEntity<List<Question>>  questionList(){
      try {
         return new ResponseEntity<>(questionService.questionList(), HttpStatus.OK);
      } catch (Exception e){
         e.printStackTrace();
      }
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
   }

   @GetMapping("/listByCategory/{cat}")
   public ResponseEntity<List<Question>> questionListByCategory(@PathVariable("cat") String category){
      try{
         return new ResponseEntity<>(questionService.questionListByCategory(category), HttpStatus.OK);
      }catch (Exception e){
         e.printStackTrace();
      }
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
   }

   @PostMapping("/addQuestion")
   public ResponseEntity<Question> addQuestion(@RequestBody Question question){
      Question newQuestion = null;
      try{
         newQuestion = questionService.addQuestion(question);
         return new ResponseEntity<>(newQuestion, HttpStatus.OK);
      } catch (Exception e){
         e.printStackTrace();
      }
      return new ResponseEntity<>(newQuestion, HttpStatus.OK);
   }

}
