package com.example.goalbook.teacher.service;

import com.example.goalbook.UserNotFoundException;
import com.example.goalbook.teacher.model.Question;
import com.example.goalbook.teacher.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question)
    {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions()
    {
        return questionRepository.findAll();
    }

    public Question findQuestion(int questionId) throws UserNotFoundException {
        Question question = questionRepository.findByQuestionId(questionId);
        if(question!=null)
        {
            return question;
        }
        else
        {
            throw new UserNotFoundException("Cannot find Teacher for ID: " + questionId);
        }
    }


}
