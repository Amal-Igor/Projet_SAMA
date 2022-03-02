package fr.dawan.SamaTravel.service;

import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.entities.AppUser;

public interface IAppUserService {
	
	
	
	//Methode permettant de retourner un utilisateur
	public AppUser findUserByUsername(String username);
	
	//TODO Définir ajout user ///
	
	
}
