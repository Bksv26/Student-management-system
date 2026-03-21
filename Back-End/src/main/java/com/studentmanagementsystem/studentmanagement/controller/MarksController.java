package com.studentmanagementsystem.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagementsystem.studentmanagement.entity.Marks;
import com.studentmanagementsystem.studentmanagement.service.MarksService;
@RestController
@RequestMapping("/marks")
@CrossOrigin("http://localhost:3000")
public class MarksController {
	 @Autowired
	    private MarksService marksservice;

	    @GetMapping("/all")
	    public List<Marks> getMarksForTeacher() {
	        return marksservice.getAllMarks();
	    }
	    
	    @PutMapping("/update/{mid}")
	    public Marks updateMarksByMid(
	            @PathVariable int mid,
	            @RequestBody Marks marks) {

	        return marksservice.updateMarksByMid(mid, marks);
	    }
	    
	    
	    @GetMapping("/student/{srollno}")
	    public List<Marks> getMarksByRollNo(@PathVariable int srollno) {
	        return marksservice.getMarksBySrollno(srollno);
	    }
}
