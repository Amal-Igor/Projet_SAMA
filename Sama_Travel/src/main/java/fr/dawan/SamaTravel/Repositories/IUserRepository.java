package fr.dawan.SamaTravel.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	
	//List<User> findAllEmail();
}
