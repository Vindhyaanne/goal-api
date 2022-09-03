package com.example.goalbook.student.service;

import com.example.goalbook.UserNotFoundException;
import com.example.goalbook.student.model.Student;
import com.example.goalbook.student.repository.StudentRepository;
import com.example.goalbook.teacher.model.Teacher;
import com.example.goalbook.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public Student findStudent(int studentId) throws UserNotFoundException {
        Student student = studentRepository.findByStudentId(studentId);
        if(student!=null)
        {
            return student;
        }
        else
        {
            throw new UserNotFoundException("Cannot find Student for ID: " + studentId);
        }
    }


}
