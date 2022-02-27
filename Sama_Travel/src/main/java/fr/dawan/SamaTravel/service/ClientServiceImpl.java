package fr.dawan.SamaTravel.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.dto.ClientDto;
import fr.dawan.SamaTravel.entities.Client;
import fr.dawan.SamaTravel.repositories.IClientRepository;

//TODO: Finir l'implémentation de la fonctionnalité d'inscription

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	IClientRepository repo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public void insertUser(Client c) {
		repo.save(c);
	}

	@Override
	public void update(Client c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Client loadUserByEmail(String email) {
		Client client = repo.findByEmail(email);
		return client;
	}

	@Override
	public ClientDto getClientByEmail(String email) {
		return mapper.map(repo.findByEmail(email), ClientDto.class);
	}

}
