package com.RFOA.RFOA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RFOA.RFOA.model.User;
import com.RFOA.RFOA.repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/all")
	public List<User> getAllUser(){
		return userRepository.findAll();}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable String id)
	{
		return userRepository.findById(id).get();
	
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addUser(@RequestBody User u){
		userRepository.save(u);
		return new ResponseEntity("New user added successfully",HttpStatus.OK);
	}
}
