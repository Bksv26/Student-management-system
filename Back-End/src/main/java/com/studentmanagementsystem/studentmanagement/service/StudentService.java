package com.studentmanagementsystem.studentmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.studentmanagement.entity.Attendannce;
import com.studentmanagementsystem.studentmanagement.entity.Marks;
import com.studentmanagementsystem.studentmanagement.entity.Student;
import com.studentmanagementsystem.studentmanagement.entity.Teacher;
import com.studentmanagementsystem.studentmanagement.repository.Attendancerepository;
import com.studentmanagementsystem.studentmanagement.repository.Marksrepository;
import com.studentmanagementsystem.studentmanagement.repository.Studentrepository;
import com.studentmanagementsystem.studentmanagement.repository.Teacherrepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
	public Studentrepository studentrepository;
	@Autowired
	public Attendancerepository attendancerepository;
	@Autowired
	public Marksrepository marksrepository;
	public Student addstudent(Student student) {
		Student savestudent=studentrepository.save(student);
		int rollno=savestudent.getSrollno();
		String name=savestudent.getSname();
		Attendannce attendance=new Attendannce();
		attendance.setSrollno(rollno);
		
		attendance.setAttendancedate(LocalDate.now());

		attendance.setStatus("present");
		
		
		attendancerepository.save(attendance);
		
		Marks marks=new Marks();
		marks.setSrollno(rollno);
		marks.setStudentname(name);
		marks.setSubject1("frontend");
		marks.setMarks1(0);
		marks.setSubject2("backend");
		marks.setMarks2(0);
		marks.setSubject3("database");
		marks.setMarks3(0);;
		marksrepository.save(marks);
		return savestudent;
	}
	
	
	public String  slogin(String semail,String spassword) {
		Student student=studentrepository.findBySemail(semail);
		if(student==null) {
			return "student not added";
		}if(!student.getSpassword().equals(spassword)) {
			return "Incorrect password";
		}
		return "Login Successful";
		
	}
	
	
	//get student by email
	public Student getStudentByEmail(String semail) {
        return studentrepository.findBySemail(semail);
    }
	//get all data 
	public List<Student> getAllStudents() {
        return studentrepository.findAll();
    }
	public Student getStudentBySrollno(int srollno) {
	    return studentrepository.findBySrollno(srollno);
	}
	 public Student getStudentDetails(int srollno) {
	        return studentrepository.findBySrollno(srollno);
	    }
     
	//update the data
	public Student updateStudent(int srollno, Student updatedStudent) {
	    Student student = studentrepository.findBySrollno(srollno);

	    if (student != null) {
	        
	        student.setSname(updatedStudent.getSname());
	        student.setSemail(updatedStudent.getSemail());
	        student.setSpassword(updatedStudent.getSpassword());
	        student.setSphone(updatedStudent.getSphone());
	        student.setStotalfee(updatedStudent.getStotalfee());
	        student.setSpaid(updatedStudent.getSpaid());
	        student.setSunpaid(updatedStudent.getSunpaid());
	        student.setSaddress(updatedStudent.getSaddress());
	        return studentrepository.save(student);
	         
	    }
	    return null;
	}
	// delete data
	@Transactional
	public boolean deleteStudent(int srollno) {
		attendancerepository.deleteBySrollno(srollno);
	    marksrepository.deleteBySrollno(srollno);
		 Student student = studentrepository.findBySrollno(srollno);
	        if (student != null) {
	            studentrepository.delete(student);
	            return true;
	        }
	        return false; 
	}


}
