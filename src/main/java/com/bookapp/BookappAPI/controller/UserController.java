package com.bookapp.bookappapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.bookappapi.dao.UserRepository;
import com.bookapp.bookappapi.model.User;

@RestController // to develop rest api

public class UserController {

	@Autowired
	UserRepository userRepository;

	
		
	
	
	
	@PostMapping("Users/save")
	public void save(@RequestBody User user) {
		userRepository.save(user);
	}

	@GetMapping("Users/list")
	public List<User> findAll() {
		List<User> UserList = userRepository.findAll();
		return UserList;

	}

	@DeleteMapping("Users/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}

	@PutMapping("Users/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody User user) {
		user.setUser_id(id);
		userRepository.save(user);
	}

	@GetMapping("Users/findUser/{id}")
	public User findById(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}

	}
	@PostMapping("Users/login")
	public User login(@RequestBody User user) {
		Optional<User> userObj=userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
		if(userObj.isPresent()) {
			return userObj.get();
		}else {
		return null;
		
				
		}
		
	}
}
