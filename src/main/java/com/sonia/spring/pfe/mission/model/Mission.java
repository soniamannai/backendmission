package com.sonia.spring.pfe.mission.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="missions")
public class Mission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "lieu")
    private String lieu;
	
	@Column(name = "duree")
    private String duree;
	
	@Column(name = "profil")
    private String profil;
	
	@Column(name = "description")
    private String description;
	
	private String experience;
	
	

	 public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	@JsonBackReference
	 @OneToMany(mappedBy = "mission")
	 Set<CandidatureMission> candidatureMissions= new HashSet<>();
	 
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "mission_technologies",
	            joinColumns = @JoinColumn(name = "mission_id"),
	            inverseJoinColumns = @JoinColumn(name = "technologie_id"))
	 private List<Technologie> technologies= new ArrayList();
	 
	public List<Technologie> getTechnologies() {
			return technologies;
		}

		public void setTechnologies(List<Technologie> technologies) {
			this.technologies = technologies;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mission other = (Mission) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Set<CandidatureMission> getCandidatureMissions() {
		return candidatureMissions;
	}

	public void setCandidatureMissions(Set<CandidatureMission> candidatureMissions) {
		this.candidatureMissions = candidatureMissions;
	}

	public Mission() {
    	
    }
    
	public Mission(String lieu, String duree, String profil, String description,String experience) {
		super();
		this.lieu = lieu;
		this.duree = duree;
		this.profil = profil;
		this.description = description;
		this.experience=experience;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
