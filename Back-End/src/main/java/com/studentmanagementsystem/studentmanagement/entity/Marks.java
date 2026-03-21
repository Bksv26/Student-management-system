package com.studentmanagementsystem.studentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="marks")
public class Marks {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mid")
	private int mid;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getSrollno() {
		return srollno;
	}
	public void setSrollno(int srollno) {
		this.srollno = srollno;
	}
	public String getSubject1() {
		return subject1;
	}
	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	@Column(name="srollno")
	private int srollno;
	@Column(name="subject1")
	private String subject1;
	@Column(name="marks1")
	private int marks1;
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	@Column(name="studentname")
     private String studentname;
	@Column(name="subject2")
	private String subject2;
	@Column(name="marks2")
	private int marks2;
	@Column(name="subject3")
	private String subject3;
	public String getSubject2() {
		return subject2;
	}
	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public String getSubject3() {
		return subject3;
	}
	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}
	public int getMarks3() {
		return marks3;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	@Column(name="marks3")
	private int marks3;
	
     
}
