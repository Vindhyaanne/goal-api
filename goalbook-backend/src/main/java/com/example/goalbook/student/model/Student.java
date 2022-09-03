package com.example.goalbook.student.model;

import com.example.goalbook.teacher.model.Question;
import com.example.goalbook.teacher.model.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int studentId;
    private String studentName;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Set<StudentResponse> studentResponses;
}
