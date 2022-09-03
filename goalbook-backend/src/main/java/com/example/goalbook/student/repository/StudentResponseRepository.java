package com.example.goalbook.student.repository;

import com.example.goalbook.student.model.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResponseRepository extends JpaRepository<StudentResponse, Integer> {
}
