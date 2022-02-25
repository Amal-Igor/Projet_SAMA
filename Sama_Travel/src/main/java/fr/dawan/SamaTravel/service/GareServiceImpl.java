package fr.dawan.SamaTravel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.Repositories.IGareRepository;
import fr.dawan.SamaTravel.entities.Gare;

@Service
public class GareServiceImpl implements GareService{

	private IGareRepository iGareRepository;
	
	
	@Autowired
	public GareServiceImpl(IGareRepository iGareRepository) {
		super();
		this.iGareRepository = iGareRepository;
	}

	@Override
	public List<Gare> findAll() {
		return (List<Gare>) iGareRepository.findAll();
	}

	public Gare findById(int id) {
		Optional<Gare> prod = iGareRepository.findById(id);
		if(prod.isPresent()){
			return prod.get();
		}else {
			return null;
		}
	}

	@Override
	public void save(Gare gare) {
		iGareRepository.save(gare);
		
	}

	@Override
	public void deleteById(int id) {
		iGareRepository.deleteById(id);
		
	}

}
