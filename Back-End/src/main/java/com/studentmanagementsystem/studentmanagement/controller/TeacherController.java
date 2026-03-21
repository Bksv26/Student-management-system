package com.studentmanagementsystem.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.studentmanagement.entity.Student;
import com.studentmanagementsystem.studentmanagement.entity.Teacher;
import com.studentmanagementsystem.studentmanagement.service.TeacherService;
@RestController
@RequestMapping("/teacher")
@CrossOrigin("http://localhost:3000")
public class TeacherController {
	@Autowired
	public TeacherService teacherservice;
	@GetMapping("/tall")
    public List<Teacher> getAllTeachers() {
        return teacherservice.getAllTeachers();
    }
	@GetMapping("/{temail}")
    public Teacher getTeacherByTemail(@PathVariable String temail) {
        return teacherservice.getTeacherByTemail(temail);
    }
	@PutMapping("/update/{temail}")
    public Teacher updateTeacher(
            @PathVariable String temail,
            @RequestBody Teacher teacher) {
        return teacherservice.updateTeacher(temail, teacher);
    }
	 @DeleteMapping("/delete/{temail}")
	    public boolean deleteTeacher(@PathVariable String temail) {
	        return teacherservice.deleteTeacher(temail);
	    }
}
