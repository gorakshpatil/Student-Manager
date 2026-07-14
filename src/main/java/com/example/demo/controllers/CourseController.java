package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public String courseList(Model model) {

		model.addAttribute("courses", courseService.getAllCourses());

		return "courses/list";
	}

	@GetMapping("/courses/add")
	public String addCourseForm(Model model) {

		model.addAttribute("course", new Course());

		return "courses/add";
	}

	@PostMapping("/courses/save")
	public String saveCourse(@ModelAttribute Course course) {

		courseService.saveCourse(course);

		return "redirect:/courses";
	}
	
	@GetMapping("/courses/edit/{id}")
	public String editCourse(@PathVariable Long id, Model model) {

	    Course course = courseService.getCourseById(id);

	    model.addAttribute("course", course);

	    return "courses/edit";
	}
	
	@PostMapping("/courses/update")
	public String updateCourse(@ModelAttribute Course course) {

	    courseService.updateCourse(course);

	    return "redirect:/courses";
	}
	
	@GetMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable Long id) {

	    courseService.deleteCourse(id);

	    return "redirect:/courses";
	}
	
	@GetMapping("/courses/view/{id}")
	public String viewCourse(@PathVariable Long id, Model model) {

	    Course course = courseService.getCourseById(id);

	    model.addAttribute("course", course);

	    return "courses/view";
	}
}
