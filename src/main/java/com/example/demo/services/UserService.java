package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional // performing the transaction with the database
public class UserService {

	private final UserRepository userRepository;

	// user repo inter extends crud repo inter which have save method
	// we are using that save method here

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveMyUser(User user) {

		userRepository.save(user);

		// save is a method coming from interface and that interface so that we
		// have to implement some where

	}

	public List<User> showAllUsers() {

		// these method will return list of all the user objects
		List<User> users = new ArrayList<User>();

		for (User user : userRepository.findAll()) {
			users.add(user);//add elements to the arraylist
		}

		return users;

		// users we have defined in jsp page
	}
	
	public void deleteMyUser(int id) {
		userRepository.deleteById(id);
	}

	public User editUser(int id) {
		return userRepository.getOne(id);
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}
	
}
