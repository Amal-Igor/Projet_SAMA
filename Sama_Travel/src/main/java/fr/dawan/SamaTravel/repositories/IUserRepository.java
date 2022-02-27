package fr.dawan.SamaTravel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.AppUser;

public interface IUserRepository extends JpaRepository<AppUser, Integer> {
	
	public AppUser findByUsername(String username);
	}
