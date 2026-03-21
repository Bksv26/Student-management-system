package com.studentmanagementsystem.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.studentmanagementsystem.studentmanagement.entity.Attendannce;
import com.studentmanagementsystem.studentmanagement.entity.Student;

public interface Studentrepository extends JpaRepository<Student,Integer>{
	Student findBySemail(String semail);
	 Student findBySrollno(int srollno);
	
	 void deleteBySrollno(int srollno);
	 
	 
}


