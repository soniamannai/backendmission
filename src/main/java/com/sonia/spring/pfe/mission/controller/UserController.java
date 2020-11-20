package com.sonia.spring.pfe.mission.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sonia.spring.pfe.mission.model.*;
import com.sonia.spring.pfe.mission.repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAll(){
		return this.userRepository.findAll();
	}
	
	@GetMapping("{id}")
	public User getById(@PathVariable(name="id")Long id) {
		return this.userRepository.findById(id).get();
	}

}
