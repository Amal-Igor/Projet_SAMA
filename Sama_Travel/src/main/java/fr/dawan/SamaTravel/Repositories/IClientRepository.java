package fr.dawan.SamaTravel.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Integer>{
	
	
	Client findByEmail(String email);

	
}
