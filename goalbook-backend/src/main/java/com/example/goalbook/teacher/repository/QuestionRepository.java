package com.example.goalbook.teacher.repository;

import com.example.goalbook.teacher.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findByQuestionId(int questionId);
}
