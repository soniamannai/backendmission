package com.sonia.spring.pfe.mission.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="collaborateurs")
public class Collaborateur extends User {
	
	private Date dateEmbauche;
	private double salaire;
	 @JsonBackReference 
	 @OneToMany(mappedBy = "collaborateur")
	  Set<CandidatureMission> candidatureMissions = new HashSet<>();
	 
	 
	public Set<CandidatureMission> getCandidatureMissions() {
		return candidatureMissions;
	}
	public void setCandidatureMissions(Set<CandidatureMission> candidatureMissions) {
		this.candidatureMissions = candidatureMissions;
	}
	public Date getDateEmbauche() {
		return dateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public Collaborateur() {
	
	}
	public Collaborateur(String username, String email, String password, Date dateEmbauche, double salaire) {
		super(username, email, password);
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
	}
	
	
	
	
	
}
