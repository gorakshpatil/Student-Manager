package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Enrollment;
import com.example.demo.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	// Save Enrollment
	public Enrollment saveEnrollment(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}

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

	// Update Enrollment
	public Enrollment updateEnrollment(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}

	// Delete Enrollment
	public void deleteEnrollment(Long id) {
		enrollmentRepository.deleteById(id);
	}
}