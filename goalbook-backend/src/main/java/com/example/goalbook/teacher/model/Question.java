package com.example.goalbook.teacher.model;


import com.example.goalbook.student.model.Student;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int questionId;
    private String question;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;
}
