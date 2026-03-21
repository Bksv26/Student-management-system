package com.studentmanagementsystem.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.studentmanagement.entity.Student;
import com.studentmanagementsystem.studentmanagement.entity.Teacher;
import com.studentmanagementsystem.studentmanagement.repository.Studentrepository;
import com.studentmanagementsystem.studentmanagement.service.StudentService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/student")
@CrossOrigin("http://localhost:3000")
public class StudentController {
	@Autowired
	public StudentService studentservice;
	@Autowired
	public Studentrepository studentrepository;
	//Register
	@PostMapping("/add")
       public Student addstudent(@RequestBody Student student) {
    	   return studentservice.addstudent(student);
       }
	

	    @PostMapping("/slogin")
		 public String slogin(@RequestBody Student student,HttpSession session) {
			 String sresult=studentservice.slogin(student.getSemail(), student.getSpassword());
			 if(sresult.equals("Login Successful")) {
				 session.setAttribute("semail",student.getSemail());
//				 session.setAttribute("srollno", student.getSrollno());
			 }
			 return sresult;
		 }
	    @GetMapping("/email/{semail}")
	    public ResponseEntity<Student> getStudentByEmail(@PathVariable String semail) {
	        Student student = studentservice.getStudentByEmail(semail);
	        if (student == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(student);
	    }

	@PostMapping("/slogout")
    public String studentLogout(HttpSession session) {
        session.invalidate();
        return "Logout Successful";
    }
	//get all details
	 @GetMapping("/all")
	    public List<Student> getAllStudents() {
	        return studentservice.getAllStudents();
	    }
	 @GetMapping("/{srollno}")
	 public Student  getStudentBySrollno(@PathVariable int srollno) {
		 return studentservice.getStudentBySrollno(srollno);}
	     
	 @GetMapping("details/{srollno}")
	 public Student getStudentDetails(@PathVariable int srollno) {
	     return studentservice.getStudentBySrollno(srollno);
	 }


	 //update data
	 @PutMapping("/update/{srollno}")
	 public ResponseEntity<Student> updateStudent(
	         @PathVariable int srollno,
	         @RequestBody Student updatedStudent) {

	     Student student = studentservice.updateStudent(srollno, updatedStudent);

	     if (student == null) {
	         return ResponseEntity.notFound().build();   // 404 if student not found
	     }

	     return ResponseEntity.ok(student);              // 200 with updated student
	 }
	 
	
	 @DeleteMapping("delete/{srollno}")
	    public ResponseEntity<String> deleteStudent(@PathVariable int srollno) {
	        boolean isDeleted = studentservice.deleteStudent(srollno);
	        if (isDeleted) {
	            return ResponseEntity.ok("Student deleted successfully");
	        } else {
	            return ResponseEntity.status(404).body("Student not found");
	        }
	    }


}
