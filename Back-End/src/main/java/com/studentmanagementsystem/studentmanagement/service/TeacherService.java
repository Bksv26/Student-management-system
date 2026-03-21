package com.studentmanagementsystem.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.studentmanagement.entity.Student;
import com.studentmanagementsystem.studentmanagement.entity.Teacher;
import com.studentmanagementsystem.studentmanagement.repository.Teacherrepository;

import jakarta.transaction.Transactional;

@Service
public class TeacherService {
	@Autowired
	public Teacherrepository teacherrepository;
	public String  tlogin(String temail,String tpassword) {
		Teacher teacher=teacherrepository.findByTemail(temail);
		if(teacher==null) {
			return "teacher not added";
		}if(!teacher.getTpassword().equals(tpassword)) {
			return "Incorrect password";
		}
		return "Login Successful";
	}
	public List<Teacher> getAllTeachers() {
        return teacherrepository.findAll();
    }
	
	public Teacher getTeacherByTemail(String temail) {
        return teacherrepository.findByTemail(temail);
    }
	 public Teacher updateTeacher(String temail, Teacher updatedTeacher) {
	        Teacher teacher = teacherrepository.findByTemail(temail);

	        if (teacher != null) {
	            teacher.setTname(updatedTeacher.getTname());
	            teacher.setTpassword(updatedTeacher.getTpassword());
	            // add other fields if any
	            return teacherrepository.save(teacher);
	        }
	        return null;
	    }
	 @Transactional
	 public boolean deleteTeacher(String temail) {
	        Teacher teacher = teacherrepository.findByTemail(temail);
	        if (teacher != null) {
	            teacherrepository.deleteByTemail(temail);
	            return true;
	        }
	        return false;
	    }

}
