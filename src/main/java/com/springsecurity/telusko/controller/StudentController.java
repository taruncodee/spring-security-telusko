package com.springsecurity.telusko.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.telusko.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	private List<Student> students = new ArrayList<>(List.of(
				new Student(1, "a", 20),
				new Student(2, "b", 30)
			));
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	@GetMapping("csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken)request.getAttribute("_csrf");
	}
	
	@PostMapping("/students")
	public Student putStudent(@RequestBody Student student) {
		students.add(student);
		return student;
	}
}
