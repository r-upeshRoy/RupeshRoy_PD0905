package com.kratin.medAssitant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kratin.medAssitant.entities.Disease;
import com.kratin.medAssitant.entities.Reminder;
import com.kratin.medAssitant.entities.User;
import com.kratin.medAssitant.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user){
		   String message = userService.createUser(user);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getAllUser(){

		return new ResponseEntity<>(userService.findAllUser(),HttpStatus.OK);
	}
	
	
	@PostMapping("/addDisease/{id}")  
	public ResponseEntity<String> addDisease(@PathVariable Long id,@RequestBody Disease disease) {
		return new ResponseEntity<String>(userService.addDisease(id, disease),HttpStatus.OK);
	}
	
	
	@PostMapping("/addReminder/{id}")  
	public ResponseEntity<String> addReminder(@PathVariable Long id,@RequestBody Reminder reminder) {
		return new ResponseEntity<String>(userService.addReminder(id, reminder),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteReminder/{id}")
	public ResponseEntity<String> deleteReminder(@PathVariable Long id){
		
		return new ResponseEntity<String>(userService.deleteReminder(id), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginByEmail(@RequestBody User user){
		  
		return new ResponseEntity<User>(userService.loginByEmail(user), HttpStatus.OK);
	}
	
	
	

}
