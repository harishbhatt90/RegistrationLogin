package com.example.demo.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.RegistrationDto;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	private UserService userService;

	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
		// TODO Auto-generated constructor stub
	}
	
	@ModelAttribute("user")
	public RegistrationDto registrationDto() {
		return new RegistrationDto();
	}
	
	@GetMapping("/users")
	public List<User> showRegistrationForm() {
		return userService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id){
		return userService.getById(id);
	}

	@PostMapping()
	public String registerUserAccount(@ModelAttribute("user") RegistrationDto registrationDto) {
		userService.save(User.builder().firstName(registrationDto.getFirstName()).lastName(registrationDto.getLastName()).id(registrationDto.getId()).build());
		return "redirect:/registration?success";
	}
	
}
