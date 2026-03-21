package com.studentmanagementsystem.studentmanagement.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagementsystem.studentmanagement.entity.Attendannce;

public interface Attendancerepository extends JpaRepository<Attendannce ,Long>{
	void deleteBySrollno(int srollno);
	
    Attendannce findBySrollnoAndAttendancedate(int srollno, LocalDate attendancedate);

    List<Attendannce> findByAttendancedate(LocalDate attendancedate);

}
