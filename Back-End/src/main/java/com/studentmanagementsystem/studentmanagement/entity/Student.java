package com.studentmanagementsystem.studentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studentdetails")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sid")
	private int sid;
	@Column(name="srollno")
    private int srollno;
	@Column(name="sname")
    private String sname;
	@Column(name="semail")
    private String semail;
	@Column(name="spassword")
    private String spassword;
	@Column(name="sphone")
    private String sphone;
	@Column(name="stotalfee")
    private double stotalfee;
	@Column(name="spaid")
    private double spaid;
	@Column(name="sunpaid")
    private double sunpaid;
	@Column(name="saddress")
    private String saddress;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getSrollno() {
		return srollno;
	}
	public void setSrollno(int srollno) {
		this.srollno = srollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public double getStotalfee() {
		return stotalfee;
	}
	public void setStotalfee(double stotalfee) {
		this.stotalfee = stotalfee;
	}
	public double getSpaid() {
		return spaid;
	}
	public void setSpaid(double spaid) {
		this.spaid = spaid;
	}
	public double getSunpaid() {
		return sunpaid;
	}
	public void setSunpaid(double sunpaid) {
		this.sunpaid = sunpaid;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

    
}
