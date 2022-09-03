package com.example.goalbook.student.controller;


import com.example.goalbook.UserNotFoundException;
import com.example.goalbook.student.model.Student;
import com.example.goalbook.student.model.StudentResponse;
import com.example.goalbook.student.repository.StudentRepository;
import com.example.goalbook.student.repository.StudentResponseRepository;
import com.example.goalbook.student.service.StudentService;
import com.example.goalbook.teacher.model.Question;
import com.example.goalbook.teacher.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentResponseRepository studentResponseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public ResponseEntity<Student> createStudent(@RequestBody @Valid Student student)
    {
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> findTeachers()
    {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findTeacher(@PathVariable int studentId) throws UserNotFoundException {
        return ResponseEntity.ok(studentService.findStudent(studentId));
    }

    @PutMapping("/{studentId}")
    public StudentResponse saveStudentResponse(
            @PathVariable int studentId,
            @RequestBody StudentResponse studentResponse
    ) {
        StudentResponse res = studentResponseRepository.save(studentResponse);
        Student student = studentRepository.findById(studentId).get();
        //Question question = questionRepository.findById(questionId).get();
        res.setStudent(student);
        return studentResponseRepository.save(res);
    }
}
