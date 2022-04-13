package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//	@GetMapping(value="/getuser")
//	public String getUsers() {
//		return "Hello This is String";
//		
//	}
	public static List<String>users=new ArrayList<>();
	
	@PostMapping(value="/addUser")
	public String addUser(@RequestParam("userName")String userName) {
		users.add(userName);
		return userName+"isAdded";
	}
	
	@GetMapping("/getUser")
	public List<String> getUsers() {
		
		users.add("mike");
		users.add("rishi");
		users.add("jacob");
		users.add("jatin");
		return users;
	}
}
