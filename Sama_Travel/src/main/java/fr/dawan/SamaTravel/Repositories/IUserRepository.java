package fr.dawan.SamaTravel.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
