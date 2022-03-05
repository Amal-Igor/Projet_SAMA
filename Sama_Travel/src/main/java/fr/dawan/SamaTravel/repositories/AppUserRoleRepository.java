package fr.dawan.SamaTravel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.AppUserRole;

public interface AppUserRoleRepository extends JpaRepository<AppUserRole, Long> {
	
	
	AppUserRole findByName(String  name);
			
	
}
