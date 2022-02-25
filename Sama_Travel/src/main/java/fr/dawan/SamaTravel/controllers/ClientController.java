package fr.dawan.SamaTravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.entities.Client;
import fr.dawan.SamaTravel.service.ClientService;

@RestController
public class ClientController {
	
	
	@Autowired
	ClientService service;
	
	@PostMapping(value="/signup", consumes="application/json", produces="text/plain")
	public ResponseEntity<String> insertProduit(@RequestBody Client p){
		service.insertUser(p);
		return new ResponseEntity<String>("Le compte client a bien été crée !", HttpStatus.CREATED);
	}
}
