package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.User;
import com.example.demo.web.dto.RegistrationDto;

public interface UserService {

	User save(RegistrationDto registrationDto);

	User save(User user);

	User getById(Long id);

	List<User> getUsers();
}
