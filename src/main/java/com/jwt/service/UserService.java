package com.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.model.User;

@Service
public class UserService {

	private List<User> store = new ArrayList<>();

	public UserService() {
		store.add(new User(UUID.randomUUID().toString(), "Dev", "dev@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "Anil", "anil@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "Suraj", "suraj@gmail.com"));

	}

	public List<User> getUsers() {
		return this.store;
	}
}
