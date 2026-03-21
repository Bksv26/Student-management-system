package com.studentmanagementsystem.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagementsystem.studentmanagement.entity.Admin;

public interface Adminrepository extends JpaRepository<Admin,Integer> {
	Admin findByAdminemail(String adminemail);

}
