package com.studentmanagementsystem.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagementsystem.studentmanagement.entity.Teacher;

public interface Teacherrepository extends JpaRepository<Teacher,Integer>{
    Teacher findByTemail(String temail);
    void deleteByTemail(String temail);
}
