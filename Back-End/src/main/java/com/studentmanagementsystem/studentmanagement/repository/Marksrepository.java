package com.studentmanagementsystem.studentmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentmanagementsystem.studentmanagement.entity.Marks;

public interface Marksrepository extends JpaRepository<Marks,Integer>{
	void deleteBySrollno(int srollno);
	@Query("SELECT m FROM Marks m")
    List<Marks> getAllMarks();
	List<Marks> findBySrollno(int srollno);

}
