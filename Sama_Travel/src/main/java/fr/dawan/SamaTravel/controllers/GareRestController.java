package fr.dawan.SamaTravel.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.entities.Gare;
import fr.dawan.SamaTravel.service.GareService;

@RestController
@RequestMapping("/api")
public class GareRestController {
	
	private GareService gareService;
	
	@Autowired
	public GareRestController(GareService gareService) {
		super();
		this.gareService = gareService;
	}

	@GetMapping("/gares")
	public List<Gare> findAll() {
		return gareService.findAll();
	}
}
