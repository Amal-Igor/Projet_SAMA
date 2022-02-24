package fr.dawan.SamaTravel.service;

import java.util.List;

import fr.dawan.SamaTravel.entities.Gare;


public interface GareService {

	public List<Gare> findAll();
	public Gare findById(int Id);
	public void save(Gare gare);
	public void deleteById(int Id);
	
}

