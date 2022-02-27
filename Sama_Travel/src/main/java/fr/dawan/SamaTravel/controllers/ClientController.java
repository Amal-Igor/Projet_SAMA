package fr.dawan.SamaTravel.controllers;

import java.util.ArrayList;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.Repositories.IClientRepository;

import fr.dawan.SamaTravel.dto.ClientDto;
import fr.dawan.SamaTravel.entities.Client;
import fr.dawan.SamaTravel.service.ClientService;

//TODO: Ajouter le cas ou un user est mal inséré

@RestController
public class ClientController {

	@Autowired
	IClientRepository repo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	ClientService service;

	@PostMapping(value = "/signup", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> insertProduit(@RequestBody Client c) {
		service.insertUser(c);
		return new ResponseEntity<String>("Le compte client a bien été crée !", HttpStatus.CREATED);
	}

	@PostMapping(value = "/login", consumes = "application/json", produces = "text/plain")
	public ResponseEntity<String> loginClient(@RequestBody ClientDto clientDto) {

		// Réupération des inputs côté client pour effectuer la comapraison avec les
		// infos compris dans la DB(donc repo)
		String inputedEmail = clientDto.getEmail();
		String inputedPassword = clientDto.getPassword();

		if (repo.findByEmail(inputedEmail) != null) {
			return new ResponseEntity<String>("Vous êtes connecté", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Fail", HttpStatus.NOT_FOUND);
		}
	}

}
