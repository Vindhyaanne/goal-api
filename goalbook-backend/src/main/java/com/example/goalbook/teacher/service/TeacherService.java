package com.example.goalbook.teacher.service;

import com.example.goalbook.UserNotFoundException;
import com.example.goalbook.teacher.model.Teacher;
import com.example.goalbook.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher)
    {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers()
    {
        return teacherRepository.findAll();
    }

    public Teacher findTeacher(int teacherId) throws UserNotFoundException {
        Teacher teacher = teacherRepository.findByTeacherId(teacherId);
        if(teacher!=null)
        {
            return teacher;
        }
        else
        {
            throw new UserNotFoundException("Cannot find Teacher for ID: " + teacherId);
        }
    }


}
