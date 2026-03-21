package com.studentmanagementsystem.studentmanagement.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendannce {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aid")
	private Long aid;
	@Column(name="srollno")
	private int srollno;
	
	
	
	public int getSrollno() {
		return srollno;
	}
	public void setSrollno(int srollno) {
		this.srollno = srollno;
	}
	
	
	@Column(name="dateattendance")
	private LocalDate attendancedate;
	@Column(name="status")
	private String status;



	public LocalDate getAttendancedate() {
		return attendancedate;
	}
	public void setAttendancedate(LocalDate attendancedate) {
		this.attendancedate = attendancedate;
	}
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
