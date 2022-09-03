package com.example.goalbook.teacher.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int teacherId;
    private String teacherName;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Question> questions;
}
