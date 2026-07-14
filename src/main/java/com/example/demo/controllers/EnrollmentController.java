package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Enrollment;
import com.example.demo.services.CourseService;
import com.example.demo.services.EnrollmentService;
import com.example.demo.services.StudentService;

@Controller
public class EnrollmentController {
	
	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/enrollments")
    public String enrollmentList(Model model) {

        model.addAttribute("enrollments",
                enrollmentService.getAllEnrollments());

        return "enrollments/list";
    }
    
    @GetMapping("/enrollments/add")
    public String addEnrollmentForm(Model model) {

        model.addAttribute("enrollment", new Enrollment());

        model.addAttribute("students",
                studentService.getAllStudents());

        model.addAttribute("courses",
                courseService.getAllCourses());

        return "enrollments/add";
    }
    
    @PostMapping("/enrollments/save")
    public String saveEnrollment(@ModelAttribute Enrollment enrollment) {

        enrollmentService.saveEnrollment(enrollment);

        return "redirect:/enrollments";
    }
    
    @GetMapping("/enrollments/edit/{id}")
    public String editEnrollment(@PathVariable Long id, Model model) {

        Enrollment enrollment = enrollmentService.getEnrollmentById(id);

        model.addAttribute("enrollment", enrollment);
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("courses", courseService.getAllCourses());

        return "enrollments/edit";
    }
    
    @PostMapping("/enrollments/update")
    public String updateEnrollment(@ModelAttribute Enrollment enrollment) {

        enrollmentService.updateEnrollment(enrollment);

        return "redirect:/enrollments";
    }
    
    @GetMapping("/enrollments/delete/{id}")
    public String deleteEnrollment(@PathVariable Long id) {

        enrollmentService.deleteEnrollment(id);

        return "redirect:/enrollments";
    }
    
    @GetMapping("/enrollments/view/{id}")
    public String viewEnrollment(@PathVariable Long id,
                                 Model model) {

        Enrollment enrollment =
                enrollmentService.getEnrollmentById(id);

        model.addAttribute("enrollment", enrollment);

        return "enrollments/view";
    }
}