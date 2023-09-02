package com.mcq.quiz.dao;

import com.mcq.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    public List<Question> findByCategory(String category);

    @Query(value = "select * from question where category=:category order by RAND() limit :numQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
