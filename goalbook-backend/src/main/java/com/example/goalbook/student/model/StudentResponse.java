package com.example.goalbook.student.model;

import com.example.goalbook.teacher.model.Teacher;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class StudentResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int responseId;
    private String responseData;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;
}
