package com.sonia.spring.pfe.mission.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonia.spring.pfe.mission.exception.ResourceNotFoundException;
import com.sonia.spring.pfe.mission.model.Mission;
import com.sonia.spring.pfe.mission.repository.MissionRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/missions")
public class MissionController {

	@Autowired
	private MissionRepository missionRepository;
	
	//get all missions
		@GetMapping("/missions")
		public List<Mission> getAllMissions(){
			return missionRepository.findAll();
			
		}
		
		
		//create mission rest api
		@PostMapping("/missions")
		public Mission createMission(@RequestBody Mission mission) {
			return missionRepository.save(mission);
		}		
		
		
		// get mission by id rest api
		@GetMapping("/missions/{id}")
		public ResponseEntity<Mission> getEmployeeById(@PathVariable Long id) {
			Mission mission = missionRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Mission not exist with id :" + id));
			return ResponseEntity.ok(mission);
		}
		
		//update mission
		@PutMapping("/missions/{id}")
		public ResponseEntity<Mission> updateMission(@PathVariable Long id, @RequestBody Mission missionDetails){
			Mission mission = missionRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Mission not exist with id :" + id));
			
			mission.setExperience(missionDetails.getExperience());
			mission.setLieu(missionDetails.getLieu());
			mission.setDuree(missionDetails.getDuree());
			mission.setProfil(missionDetails.getProfil());
			mission.setDescription(missionDetails.getDescription());
			mission.setTechnologies(missionDetails.getTechnologies());
			
			Mission updatedMission = missionRepository.save(mission);
			return ResponseEntity.ok(updatedMission);
		}
		
		
		// delete mission rest api
		@DeleteMapping("/missions/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteMission(@PathVariable Long id){
			Mission mission= missionRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Mission not exist with id :" + id));
			
			missionRepository.delete(mission);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
		
}
