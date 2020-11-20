package com.sonia.spring.pfe.mission.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sonia.spring.pfe.mission.model.*;
import com.sonia.spring.pfe.mission.repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/candidatures")
public class CandidatureMissionController {
	
	@Autowired
	private CollaborateurRepository collaborateurRepository;
	@Autowired
	private MissionRepository missionRepository;
	@Autowired
	private CandidatureMissionRepository candidatureMissionRepository;
	@Autowired
	private TechnologieRepository technologieRepository;
	
	@GetMapping("/candidatures")
	public List<CandidatureMission> getAll(){
		return this.candidatureMissionRepository.findAll();
	}
	
	@GetMapping("/test")
	public void test() {
		Collaborateur collaborateur=this.collaborateurRepository.getOne(1L);
		Mission mission=this.missionRepository.getOne(17L);
		List<Technologie> technologies=this.technologieRepository.findAll();
		CandidatureMission candidatureMission =new CandidatureMission(collaborateur,mission,
				"aze","azea","azeza","'azeaz",new Date(),technologies,12,"English");
		this.candidatureMissionRepository.save(candidatureMission);
	}
	

	@PostMapping(value="/candidatures",produces = "application/json")
	public CandidatureMission add(@RequestBody CandidatureMission candidatureMission) {
		return this.candidatureMissionRepository.save(candidatureMission);
	}

}
