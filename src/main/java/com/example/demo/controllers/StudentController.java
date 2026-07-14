package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Student;
import com.example.demo.services.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public String studentList(
	        @RequestParam(required = false) String keyword,
	        Model model) {

	    if (keyword != null && !keyword.trim().isEmpty()) {
	        model.addAttribute("students",
	                studentService.searchStudents(keyword));
	    } else {
	        model.addAttribute("students",
	                studentService.getAllStudents());
	    }

	    model.addAttribute("keyword", keyword);

	    return "students/list";
	}

	@GetMapping("/students/add")
	public String addStudentForm(Model model) {

		model.addAttribute("student", new Student());

		return "students/add";
	}

	@PostMapping("/students/save")
	public String saveStudent(@ModelAttribute Student student) {

		studentService.saveStudent(student);

		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {

		Student student = studentService.getStudentById(id);

		model.addAttribute("student", student);

		return "students/edit";
	}

	@PostMapping("/students/update")
	public String updateStudent(@ModelAttribute Student student) {

		studentService.updateStudent(student);

		return "redirect:/students";
	}

	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {

		studentService.deleteStudent(id);

		return "redirect:/students";
	}
	
	@GetMapping("/students/view/{id}")
	public String viewStudent(@PathVariable Long id, Model model) {

	    Student student = studentService.getStudentById(id);

	    model.addAttribute("student", student);

	    return "students/view";
	}

}