package com.studentmanagementsystem.studentmanagement.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.studentmanagement.entity.Attendannce;
import com.studentmanagementsystem.studentmanagement.service.AttendanceService;
@RestController
@RequestMapping("/attendance")
@CrossOrigin("http://localhost:3000")
public class AttendanceController {
	@Autowired
public AttendanceService attendanceservice;
	
	@PostMapping("/mark")
    public ResponseEntity<String> markAttendance(
            @RequestParam int srollno,
            @RequestParam String status) {

        return ResponseEntity.ok(
            attendanceservice.markAttendance(srollno, status)
        );
    }

    @GetMapping("/today")
    public List<Attendannce> getTodayAttendance() {
        return attendanceservice.getTodayAttendance();
    }
}
