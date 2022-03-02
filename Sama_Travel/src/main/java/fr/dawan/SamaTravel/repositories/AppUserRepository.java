package fr.dawan.SamaTravel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	
	public AppUser findByUsername(String username);
	
	}
