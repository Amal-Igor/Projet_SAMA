package fr.dawan.SamaTravel.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.SamaTravel.entities.Train;

public interface ITrainRepository extends JpaRepository<Train, Integer> {

}
