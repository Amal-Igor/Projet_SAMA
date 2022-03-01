package fr.dawan.SamaTravel.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.repositories.AppUserRepository;

@Service
@Transactional
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private AppUserService userService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
	 //return new User(user.getUsername(), user.getPassword(), new ArrayList<>()); //Granted authority
	AppUser user =	userService.findUserByUsername(username);
	
	//System.out.println(user);
	
	//TODO Si on veut changer le moyen d'identification changer par user.getEmail();
	return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
	
}
	