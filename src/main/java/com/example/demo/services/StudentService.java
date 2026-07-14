package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public long countStudents() {
		return studentRepository.count();
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	public List<Student> searchStudents(String keyword) {

		return studentRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword);
	}

	public Page<Student> getStudentsWithPagination(Pageable pageable) {
		return studentRepository.findAll(pageable);
	}

}