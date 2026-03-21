package com.studentmanagementsystem.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.studentmanagement.entity.Admin;
import com.studentmanagementsystem.studentmanagement.entity.Student;
import com.studentmanagementsystem.studentmanagement.entity.Teacher;
import com.studentmanagementsystem.studentmanagement.service.AdminService;
import com.studentmanagementsystem.studentmanagement.service.StudentService;
import com.studentmanagementsystem.studentmanagement.service.TeacherService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:3000")
public class AdminController {
	@Autowired
	public AdminService adminservice;
	@Autowired
	public TeacherService teacherservice;
	@Autowired
	public StudentService studentservice;
	@PostMapping("/login")
	public String login(@RequestBody Admin admin,HttpSession session) {
		
		 String result = adminservice.login(admin.getAdminemail(), admin.getAdminpassword());
	        if (result.equals("Login Successful")) {
	            
	            session.setAttribute("adminEmail", admin.getAdminemail());
	        }
	        return result;
	    }
	 @PostMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "Logout Successful";
	    }
	 @PostMapping("/tlogin")
	 public String tlogin(@RequestBody Teacher teacher,HttpSession session) {
		 String tresult=teacherservice.tlogin(teacher.getTemail(), teacher.getTpassword());
		 if(tresult.equals("Login Successful")) {
			 session.setAttribute("temail", teacher.getTemail());
		 }
		 return tresult;
	 }
	 
	 @PostMapping("/tlogout")
	    public String teacherLogout(HttpSession session) {
	        session.invalidate();
	        return "Teacher Logout Successful";
	    }
	 @PutMapping("/update/{srollno}")
	 public Student updateStudent(@PathVariable int srollno, @RequestBody Student updatedStudent) {
	     return studentservice.updateStudent(srollno, updatedStudent);
	 }

	 

}
