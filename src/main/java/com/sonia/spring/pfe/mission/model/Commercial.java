package com.sonia.spring.pfe.mission.model;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="commerciaux")
public class Commercial extends User {

	public Commercial() {
	}

	public Commercial(String username, String email, String password) {
		super(username, email, password);
		// TODO Auto-generated constructor stub
	}

	
	

}
