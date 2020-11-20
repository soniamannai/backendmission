package com.sonia.spring.pfe.mission.model;
import javax.persistence.*;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class CandidatureMission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @ManyToOne
	 @JoinColumn(name = "collaborateur_id")
	 private Collaborateur collaborateur;
	 @ManyToOne
	 @JoinColumn(name="mission_id")
	 private Mission mission;
	 private String nom;
	 private String prenom;
	 private String email;
	 private String diplome;
	 private Date anneeObtention;
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "candidature_mission_technologies",
	            joinColumns = @JoinColumn(name = "candidature_mission_id"),
	            inverseJoinColumns = @JoinColumn(name = "technologie_id"))
	 private List<Technologie> technologieMatrise;
	 private int experience;
	 private String langue;
	 
	 public CandidatureMission() {
		 
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public Date getAnneObtention() {
		return anneeObtention;
	}

	public void setAnneObtention(Date anneObtention) {
		this.anneeObtention = anneObtention;
	}

	public List<Technologie> getTechnologieMatrise() {
		return technologieMatrise;
	}

	public void setTechnologieMatrise(List<Technologie> technologieMatrise) {
		this.technologieMatrise = technologieMatrise;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public CandidatureMission(Collaborateur collaborateur, Mission mission, String nom, String prenom, String email,
			String diplome, Date anneObtention, List<Technologie> technologieMatrise, int experience, String langue) {
		super();
		this.collaborateur = collaborateur;
		this.mission = mission;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.diplome = diplome;
		this.anneeObtention = anneObtention;
		this.technologieMatrise = technologieMatrise;
		this.experience = experience;
		this.langue = langue;
	}
	 
	 
	 
	 

}
