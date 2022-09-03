package com.example.goalbook.teacher.repository;

import com.example.goalbook.teacher.dto.ResponseTeacherData;
import com.example.goalbook.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByTeacherId(int userId);

    @Query("SELECT new com.example.goalbook.teacher.dto.ResponseTeacherData(t.teacherName, q.question) FROM Teacher t join t.questions q")
    public List<ResponseTeacherData> getJoinInformation();
}
