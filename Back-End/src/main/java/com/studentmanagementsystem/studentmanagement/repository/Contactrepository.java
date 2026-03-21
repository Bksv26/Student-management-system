package com.studentmanagementsystem.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagementsystem.studentmanagement.entity.Contact;

public interface Contactrepository extends JpaRepository<Contact,Integer>{
  
}
