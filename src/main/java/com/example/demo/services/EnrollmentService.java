package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.entities.Enrollment;
import com.example.demo.entities.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class EnrollmentService {
	

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	// Get All Enrollments
	public List<Enrollment> getAllEnrollments() {
		return enrollmentRepository.findAll();
	}

	public long countEnrollments() {
		return enrollmentRepository.count();
	}

	// Get Enrollment By Id
	public Enrollment getEnrollmentById(Long id) {
		return enrollmentRepository.findById(id).orElse(null);
	}


	// Delete Enrollment
	public void deleteEnrollment(Long id) {
		enrollmentRepository.deleteById(id);
	}
	
	public Enrollment saveEnrollment(Enrollment enrollment) {

	    Student student = studentRepository
	            .findById(enrollment.getStudent().getId())
	            .orElseThrow(() -> new RuntimeException("Student not found"));

	    Course course = courseRepository
	            .findById(enrollment.getCourse().getId())
	            .orElseThrow(() -> new RuntimeException("Course not found"));

	    enrollment.setStudent(student);
	    enrollment.setCourse(course);

	    return enrollmentRepository.save(enrollment);
	}
	
	public Enrollment updateEnrollment(Enrollment enrollment) {

	    Student student = studentRepository
	            .findById(enrollment.getStudent().getId())
	            .orElseThrow(() -> new RuntimeException("Student not found"));

	    Course course = courseRepository
	            .findById(enrollment.getCourse().getId())
	            .orElseThrow(() -> new RuntimeException("Course not found"));

	    enrollment.setStudent(student);
	    enrollment.setCourse(course);

	    return enrollmentRepository.save(enrollment);
	}
	
}