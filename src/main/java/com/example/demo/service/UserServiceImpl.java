package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.RegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}


	@Override
	public User save(RegistrationDto registrationDto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		User userlist=userRepository.getById(id);
		return userlist;
	}


	@Override
	public List<User> getUsers() {
		List<User> users=userRepository.findAll();
		return users;
	}

}
