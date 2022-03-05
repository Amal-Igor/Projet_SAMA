package fr.dawan.SamaTravel.service;

import java.util.List;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.entities.AppUserRole;
import fr.dawan.SamaTravel.entities.TypeUser;

public interface IAppUserService {
	
	
	
	//Methode permettant de retourner un utilisateur
	public AppUser findByUsername(String username);

	public void saveUser(AppUser appUser);
	
//	//Methode permettant d'ajouter un role dans notre Application
//	public AppUserRole saveRole(AppUserRole role);
//		
		//Methode permettant d'ajouter un rôle à un utilisateur
	public void addRoleToUser(String username, String roleName);

	AppUserRole saveRole(AppUserRole role);
	

	List<AppUser> getAllAppUser();

	
}
