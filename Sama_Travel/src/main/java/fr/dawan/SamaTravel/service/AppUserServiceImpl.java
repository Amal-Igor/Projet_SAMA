package fr.dawan.SamaTravel.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.entities.AppUserRole;
//import fr.dawan.SamaTravel.entities.AppUserRole;
import fr.dawan.SamaTravel.repositories.AppUserRepository;
import fr.dawan.SamaTravel.repositories.AppUserRoleRepository;


@Service
public class AppUserServiceImpl implements IAppUserService {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	AppUserRepository appUserRepository;
	
	@Autowired
	AppUserRoleRepository roleRepository;
	
	@Override
	public AppUser findByUsername(String username) {
		
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void saveUser(AppUser appUser) {
		String hashedPw = bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(hashedPw);
		AppUser user  = new AppUser();
		
		
		AppUserRole role = roleRepository.findByName("CLIENT");
		Set<AppUserRole> roleSet = new HashSet<>();
        roleSet.add(role);
//		AppUserRole role = roleRepository.findByName("USER");
//		Collection<AppUserRole> roleCollection= new ArrayList<>();
//		roleCollection.add(role);
//		
//		user.setRoles(roleCollection);
		appUser.setRoles(roleSet);
        
        
		appUserRepository.save(appUser);
		
		
	}

//	@Override
//	public AppUserRole saveRole(AppUserRole role) {
//		return roleRepository.save(role);
//	}

//	@Override
//	public void addRoleToUser(String username, String roleName) {
//		// TODO Auto-generated method stub
//		
//	}



	@Override
	public void addRoleToUser(String username, String roleName) {
		//On recupère le rôle, et l'utilisateur
				AppUserRole role = roleRepository.findByName(roleName);
				AppUser user = appUserRepository.findByUsername(username);
				
				/*
				 * On accède à la liste des role de l'utilisateur afin de lui ajouter 
				 * le role.
				 * Comme la methode est transactionnel: 
				 * Dès qu'il fait commit; automatiquement il sait qu'on ajouté un rôle 
				 * et automatiquement il l'ajoute au niveau de la base de données
				 */
				user.getRoles().add(role);		
	}

}
