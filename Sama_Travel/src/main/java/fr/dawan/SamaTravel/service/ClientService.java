package fr.dawan.SamaTravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.Repositories.IClientRepository;
import fr.dawan.SamaTravel.entities.Client;



//TODO: Finir l'implémentation de la fonctionnalité d'inscription

@Service
public class ClientService {
	
	@Autowired
	IClientRepository repo;
	
	
	//Methode pour enregistrée un user
	public void insertUser(Client c) {
		repo.save(c);
	}
	
	
}
