package fr.dawan.SamaTravel.service;

import java.util.List;

import fr.dawan.SamaTravel.dto.ClientDto;
import fr.dawan.SamaTravel.entities.Client;

public interface ClientService {

	
	public void insertUser(Client c);
	
	public void update(Client c);
	
	public Client loadUserByEmail(String email);
		
	ClientDto getClientByEmail(String email);
}
