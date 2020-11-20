package com.sonia.spring.pfe.mission.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sonia.spring.pfe.mission.model.*;
import com.sonia.spring.pfe.mission.repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/technologies")
public class TechnologieController {
	
	@Autowired
	private TechnologieRepository technologieRepository;
	
	@GetMapping("/technologies")
	public List<Technologie> getAll(){
		System.out.println(this.technologieRepository.findAll());
		return this.technologieRepository.findAll();
	}

}
