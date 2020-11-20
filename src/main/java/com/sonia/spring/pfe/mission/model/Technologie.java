package com.sonia.spring.pfe.mission.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
@Entity
public class Technologie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "technologieMatrise", fetch = FetchType.LAZY)
    private List<CandidatureMission> candidatureMissions=new ArrayList<>();
    
    @ManyToMany(mappedBy = "technologies", fetch = FetchType.LAZY)
    
    @JsonIgnore
    private List<Mission> missions=new ArrayList<>();
    
	public List<CandidatureMission> getCandidatureMissions() {
		return candidatureMissions;
	}
	public void setCandidatureMissions(List<CandidatureMission> candidatureMissions) {
		this.candidatureMissions = candidatureMissions;
	}
	public List<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}
	public Technologie() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Technologie(String name) {
		super();
		this.name = name;
	}
	
}
