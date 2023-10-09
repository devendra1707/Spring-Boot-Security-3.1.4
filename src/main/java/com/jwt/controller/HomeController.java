package com.jwt.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.User;
import com.jwt.service.UserService;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public String test() {
		return "Api is working";
	}

	@GetMapping(value = "/users")
	public List<User> getUser() {
		System.out.println("Getting users");
		return userService.getUsers();
	}

	@GetMapping(value = "/currentUser")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		
		return userService.createUser(user);
	}
}
