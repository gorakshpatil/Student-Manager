package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Save User
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	// Get All Users
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Get User By Id
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	// Get User By Username
	public Optional<User> getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	// Update User
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	// Delete User
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}