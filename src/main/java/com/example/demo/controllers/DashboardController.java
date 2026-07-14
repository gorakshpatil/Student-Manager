package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.services.CourseService;
import com.example.demo.services.EnrollmentService;
import com.example.demo.services.StudentService;

@Controller
public class DashboardController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private EnrollmentService enrollmentService;

	@GetMapping("/dashboard")
	public String dashboard(Model model) {

		model.addAttribute("studentCount", studentService.countStudents());
		model.addAttribute("courseCount", courseService.countCourses());
		model.addAttribute("enrollmentCount", enrollmentService.countEnrollments());

		return "dashboard";
	}
}