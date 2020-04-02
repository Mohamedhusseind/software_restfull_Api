package com.ecom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.User;

@Service
public class userServices {

	@Autowired
	com.ecom.repositories.userRepository userRepository;

	public List<User> getAllusers() {
		return userRepository.findAll();
	}

	public User getuserById(Long id) {
		return userRepository.findById(id).orElseThrow(null);

	}

	// search by name
	/*
	 * public List<Employee> getEmpByFirstName(String firstName) { return
	 * empoloyeeRepository.findByFirstName(firstName); }
	 */

	/*public void adduser(User newuser) {
		userRepository.save(newuser);
		
	}*/
	public void adduser(User newUser) {
		userRepository.save(newUser);
		
	}
	/*public void addNewUser(User newUser) {
		userRepository.save(newUser);
	}*/

}
