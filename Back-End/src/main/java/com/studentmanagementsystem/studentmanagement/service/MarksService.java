package com.studentmanagementsystem.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.studentmanagement.entity.Marks;
import com.studentmanagementsystem.studentmanagement.repository.Marksrepository;
@Service
public class MarksService {
	@Autowired
 public Marksrepository marksrepository;
	public List<Marks> getAllMarks() {
        return marksrepository.getAllMarks();
    }
	//get marks by srollno
	 public List<Marks> getMarksBySrollno(int srollno) {
	        return marksrepository.findBySrollno(srollno);
	    }
	//update marks

    public Marks updateMarksByMid(int mid, Marks updated) {

        Marks mark = marksrepository.findById(mid)
                .orElseThrow(() -> new RuntimeException("Marks not found with mid: " + mid));

        mark.setMarks1(updated.getMarks1());
        mark.setMarks2(updated.getMarks2());
        mark.setMarks3(updated.getMarks3());

       


        return marksrepository.save(mark);
    }
}
