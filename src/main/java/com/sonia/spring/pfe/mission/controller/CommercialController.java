package com.sonia.spring.pfe.mission.controller;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.sonia.spring.pfe.mission.model.*;
import com.sonia.spring.pfe.mission.repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/commercial")
public class CommercialController {

	@Autowired
	private CommericalRepository commercialRepository;
	
	@GetMapping("/all")
	public List<Commercial> getAll(){return this.commercialRepository.findAll();}
	
	@GetMapping("/test")
	public void test() {
		Commercial commercial=new Commercial("Commercial","com@gmail.com","1234");
		this.commercialRepository.save(commercial);
	}
	
}
