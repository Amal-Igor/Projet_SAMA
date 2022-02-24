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

	@Override
	public Gare findById(int id) {
		Optional<Gare> result = iGareRepository.findById(id);
		Gare gare = null;
		if(result.isPresent()) {
			gare = result.get();
		} else {
			throw new RuntimeException("No employe found with this Id : : " + id);
		}
		return gare;
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
