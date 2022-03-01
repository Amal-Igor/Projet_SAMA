package fr.dawan.SamaTravel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import fr.dawan.SamaTravel.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
	
	
	
	public AppUser findByUsername(String username);
	
	}
