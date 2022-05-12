package com.bookapp.bookappapi.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.bookappapi.Service.UserService;
import com.bookapp.bookappapi.Validation.UserValidation;
import com.bookapp.bookappapi.dao.UserRepository;
import com.bookapp.bookappapi.dto.MessageDTO;
import com.bookapp.bookappapi.model.Book;
import com.bookapp.bookappapi.model.User;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@PostMapping("user/save") // register details will be insert
	public ResponseEntity  <?> save(@RequestBody User user){
		try {
			userService.save(user);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("user/list") // list all users
	public List<User> findAll() {
		List<User> userlist = null;
		try {
			userlist=userService.findAll();
			}catch(Exception e) {
				e.getMessage();
			}
		return userlist;
	}
	@DeleteMapping("user/{userid}")
	public void delete(@PathVariable("userid") Integer userid) {
		userRepository.deleteById(userid);
		
	}
	@PutMapping("user/{id}")
	
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody User user) {
		try {
			userService.update(id, user);
			MessageDTO message = new MessageDTO("Success");
       return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message
					, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("user/{id}")
	public User get(@PathVariable("id") Integer id) {
		return userRepository.findById(id).get();
	}
	@PostMapping("users/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		try {
			String n=userService.login(user);
			UserValidation.validateLogin(user);
			MessageDTO message = new MessageDTO("success");
			if(n=="success") {
			return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	}
	

