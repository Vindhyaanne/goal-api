package com.example.goalbook.teacher.controller;


import com.example.goalbook.UserNotFoundException;
import com.example.goalbook.teacher.dto.QuestionRequest;
import com.example.goalbook.teacher.dto.ResponseTeacherData;
import com.example.goalbook.teacher.model.Question;
import com.example.goalbook.teacher.model.Teacher;
import com.example.goalbook.teacher.repository.QuestionRepository;
import com.example.goalbook.teacher.repository.TeacherRepository;
import com.example.goalbook.teacher.service.QuestionService;
import com.example.goalbook.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/save")
    public ResponseEntity<Teacher> createTeacher(@RequestBody @Valid Teacher teacher)
    {
        return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Teacher>> findTeachers()
    {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> findTeacher(@PathVariable int teacherId) throws UserNotFoundException {
        return ResponseEntity.ok(teacherService.findTeacher(teacherId));
    }

    @PostMapping("/askQuestion")
    public String placeOrder(@RequestBody QuestionRequest request) {
        teacherService.saveTeacher(request.getTeacher());
        return "Saved";
    }

    @PostMapping("/question")
    public String saveQuestion(@RequestBody Question question) {
        questionService.saveQuestion(question);
        return "Saved";
    }

    @PutMapping("/{teacherId}/questions/{questionId}")
    public Question assignTeacherToQuestion(
            @PathVariable int teacherId,
            @PathVariable int questionId
    ) {
        Teacher teacher = teacherRepository.findById(teacherId).get();
        Question question = questionRepository.findById(questionId).get();
        question.setTeacher(teacher);
        return questionRepository.save(question);
    }

    @PutMapping("/{teacherId}")
    public Question assignTeacherToQuestion1(
            @PathVariable int teacherId,
            @RequestBody Question question
    ) {
        question = questionRepository.save(question);
        Teacher teacher = teacherRepository.findById(teacherId).get();
        //Question question = questionRepository.findById(questionId).get();
        question.setTeacher(teacher);
        return questionRepository.save(question);
    }

    @GetMapping("/askedQuestions")
    public List<ResponseTeacherData> getTeacherInformation()
    {
        return teacherRepository.getJoinInformation();
    }
}
