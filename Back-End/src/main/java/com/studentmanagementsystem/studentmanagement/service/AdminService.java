package com.studentmanagementsystem.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.studentmanagement.entity.Admin;
import com.studentmanagementsystem.studentmanagement.repository.Adminrepository;

@Service
public class AdminService {
	@Autowired
	public Adminrepository adminrepository;
  public String login(String adminemail,String adminpassword) {
	  Admin admin=adminrepository.findByAdminemail(adminemail);
	  if(admin==null) {
		  return "admin not added";
	  }if (!admin.getAdminpassword().equals(adminpassword)) {
          return "Incorrect password!";
      }

      return "Login Successful";
  }
	  
  }
	
	


