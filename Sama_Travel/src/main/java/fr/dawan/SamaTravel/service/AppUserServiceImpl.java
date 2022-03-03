package fr.dawan.SamaTravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.repositories.AppUserRepository;


@Service
public class AppUserServiceImpl implements IAppUserService {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	AppUserRepository appUserRepository;
	
	@Override
	public AppUser findByUsername(String username) {
		
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void saveUser(AppUser appUser) {
		
		String hashedPw = bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(hashedPw);
		appUserRepository.save(appUser);
		
	}

}
