package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String courseName;

	@Column(nullable = false, unique = true)
	private String courseCode;

	@Column(nullable = false)
	private String duration;

	@Column(nullable = false)
	private Double fees;

	@Column(length = 1000)
	private String description;

	public Course() {
	}

	public Course(Long id, String courseName, String courseCode, String duration, Double fees, String description) {
		this.id = id;
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.duration = duration;
		this.fees = fees;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}