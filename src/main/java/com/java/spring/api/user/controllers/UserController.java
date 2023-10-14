package com.java.spring.api.user.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.spring.api.user.models.User;
import com.java.spring.api.user.repositorys.UserRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private UserRepository repository;
	
	UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/home")
	public String home() {
		return "home";
	}
	
	@GetMapping(value = "/form")
	public String form(User user) {
		return "form";
	}
	
	@PostMapping(value = "/save")
	public String save(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors())
			return "/user/form";
		
		repository.save(user);
		return "redirect:/user/list";
	}
	
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<User> users = repository.findAll();
		model.addAttribute("users", users);
		return "list";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		User user = repository.findById(id)
				.orElseThrow(() -> 
				new IllegalArgumentException("Invalid user Id: " + id));
		
		repository.delete(user);
		return "redirect:/user/list";
	}
	
	@PostMapping(value = "/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid User user, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			user.setId(id);
			return "edit";
		}
		
		repository.save(user);
		return "redirect:/user/list";
	}

	@GetMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		User user = repository.findById(id)
				.orElseThrow(() -> 
				new IllegalArgumentException("Invalid user id: " + id));
		
		model.addAttribute("user", user);
		return "edit";
	}
}