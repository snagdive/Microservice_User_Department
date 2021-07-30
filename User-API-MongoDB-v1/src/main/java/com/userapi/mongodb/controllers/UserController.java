package com.userapi.mongodb.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userapi.mongodb.models.User;
import com.userapi.mongodb.services.UserService;
import com.userapi.mongodb.valueObject.ResponseObject;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/")
	public ResponseEntity<List<ResponseObject>> getAllUsers() {
		return ResponseEntity.ok(service.getAllUsers());
	}
	
	@GetMapping("/{id}")
	public ResponseObject getUserById(@PathVariable String id) {
		return service.getUserById(id);		
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = service.addUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{username}")
	public ResponseEntity<Object> deleteUser(@PathVariable String username) {
		service.deleteUser(username);
		return new ResponseEntity<Object>("User Deleted!", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/update/{id}")
	public User updateUser(@RequestBody User user, @PathVariable String id) {
		return service.updateUser(id, user);
	}	

}
