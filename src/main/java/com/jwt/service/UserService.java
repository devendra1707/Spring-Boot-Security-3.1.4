package com.jwt.service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jwt.model.User;
import com.jwt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository repository;

	public List<User> getUsers() {
		return repository.findAll();
	}

	public User createUser(User user) {
		// Check if the mobile number is already present
		User existingUser = repository.findByMobileNo(user.getMobileNo());

		if (existingUser != null) {
			// Mobile number already exists, remove the password and regenerate a new random
			// number
			Random random = new Random();
			int newOtpValue = 100_000 + random.nextInt(900_000);
			String newOtp = String.valueOf(newOtpValue);
			System.out.println("--------\n" + newOtpValue + "\n----------");

			// Update the existing user with a new random OTP as the password
			existingUser.setPassword(passwordEncoder.encode(newOtp));
			return repository.save(existingUser);
		}

		// Mobile number doesn't exist, proceed to generate a random OTP
		user.setUserId(UUID.randomUUID().toString());

		// Generate a random OTP as the password
		Random random = new Random();
		int otpValue = 100_000 + random.nextInt(900_000);
		String otp = String.valueOf(otpValue);
		System.out.println("--------\n" + otpValue + "\n----------");

		// Save the OTP to the user entity and update it in the database
		user.setPassword(passwordEncoder.encode(otp));
		return repository.save(user);
	}
}
