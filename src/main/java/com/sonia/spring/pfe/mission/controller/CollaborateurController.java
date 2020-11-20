package com.sonia.spring.pfe.mission.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sonia.spring.pfe.mission.model.Collaborateur;
import com.sonia.spring.pfe.mission.repository.CollaborateurRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/collaborateurs")
public class CollaborateurController {
	
		@Autowired
		private CollaborateurRepository collaborateurRepository;
		
		@GetMapping("/collaborateurs")
		public List<Collaborateur> getAll() {return this.collaborateurRepository.findAll();}
		@GetMapping("/test")
		public void test() {
			Collaborateur collaborateur=new Collaborateur("Collaborateur","col@gmail.com","1234",new Date(),1654);
			this.collaborateurRepository.save(collaborateur);
			
		}
		@GetMapping("{id}")
		public Collaborateur getById(@PathVariable(name = "id")Long id) {
			return this.collaborateurRepository.findById(id).get();
		}
		
}
