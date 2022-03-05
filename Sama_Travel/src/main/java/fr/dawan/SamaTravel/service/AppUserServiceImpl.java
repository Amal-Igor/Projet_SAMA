package fr.dawan.SamaTravel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.entities.AppUserRole;
import fr.dawan.SamaTravel.repositories.AppUserRepository;
import fr.dawan.SamaTravel.repositories.AppUserRoleRepository;


@Service
@Transactional
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
		
//		AppUserRole role = new AppUserRole("CLIENT");
//		Collection<AppUserRole> roleCollection= new ArrayList<>();
//		roleCollection.add(role);
//		
//		user.setRoles(roleCollection);
//		
//		AppUserRole role = new AppUserRole("CLIENT");
//		Collection<AppUserRole> roleSet = new HashSet<>();
//        roleSet.add(role);

////		
////		user.setRoles(roleCollection);
//		appUser.setRoles(roleSet);
        
        
		appUserRepository.save(appUser);
		
		
	}

	@Override
	public AppUserRole saveRole(AppUserRole role) {
		return roleRepository.save(role);
	}





	@Override
	public void addRoleToUser(String username, String rolename) {
		//On recupère le rôle, et l'utilisateur
//				AppUserRole role = roleRepository.findByRoles(TypeUser.CLIENT);
//				Collection<AppUserRole> roleCollection= new ArrayList<>();
//				roleCollection.add(role);
//				AppUserRole role = roleRepository.findByRoles(TypeUser.CLIENT);	
				//roleRepository.save(role);
//				
//					AppUserRole role = new AppUserRole(TypeUser.CLIENT);
//					AppUser user = appUserRepository.findByUsername(username);
					AppUserRole role  = roleRepository.findByName(rolename);
					AppUser user = appUserRepository.findByUsername(username);
//				
//				/*
//				 * On accède à la liste des role de l'utilisateur afin de lui ajouter 
//				 * le role.
//				 * Comme la methode est transactionnel: 
//				 * Dès qu'il fait commit; automatiquement il sait qu'on ajouté un rôle 
//				 * et automatiquement il l'ajoute au niveau de la base de données
////				 */
					user.getRoles().add(role);
				
				
	}
//
//	@Override
//	public void addRoleToUser(String username, String roleName) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public List<AppUser> getAllAppUser() {
	
		List<AppUser> lstUser = new ArrayList<AppUser>();
		lstUser = appUserRepository.findAll();
		
		return lstUser;
}

	@Override
	public List<String> getUserInformations(String username) {
		AppUser u = appUserRepository.findByUsername(username);
		List<String> lst = new ArrayList<>();
		
		Long userId = u.getId();
		String userIdToString = Long.toString(userId);
		lst.add(userIdToString);
		lst.add(u.getUsername());
		lst.add(u.getNom());
		lst.add(u.getPrenom());
		lst.add(u.getEmail());		
		
		return lst;
	}

	@Override
	public void deleteUserByUsername(String username) {
		AppUser u = appUserRepository.findByUsername(username);
		appUserRepository.delete(u);
	}
}