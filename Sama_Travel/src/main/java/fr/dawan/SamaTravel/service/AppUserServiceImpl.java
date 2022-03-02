package fr.dawan.SamaTravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.repositories.AppUserRepository;


@Service
public class AppUserServiceImpl implements IAppUserService {
	
	

	@Autowired
	AppUserRepository appUserRepository;
	
	@Override
	public AppUser findUserByUsername(String username) {

		return appUserRepository.findByUsername(username);
	}

}
