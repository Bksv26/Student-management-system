package com.studentmanagementsystem.studentmanagement.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.studentmanagement.entity.Attendannce;
import com.studentmanagementsystem.studentmanagement.repository.Attendancerepository;
@Service
public class AttendanceService {
	@Autowired
	public Attendancerepository attendancerepository;
	
	    public String markAttendance(int srollno, String status) {

	        LocalDate today = LocalDate.now();

	        Attendannce existing =
	            attendancerepository.findBySrollnoAndAttendancedate(srollno, today);

	        if (existing != null) {
	            existing.setStatus(status);
	            attendancerepository.save(existing);
	            return "Attendance updated";
	        }

	        Attendannce attendance = new Attendannce();
	        attendance.setSrollno(srollno);
	        attendance.setAttendancedate(today);
	        attendance.setStatus(status);

	        attendancerepository.save(attendance);
	        return "Attendance marked";
	    }

	    public List<Attendannce> getTodayAttendance() {
	        return attendancerepository.findByAttendancedate(LocalDate.now());
	    }

}
