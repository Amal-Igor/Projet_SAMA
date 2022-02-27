package fr.dawan.SamaTravel.service;

import fr.dawan.SamaTravel.entities.Client;
import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.entities.UserRole;



public interface IUserService {
	
	public AppUser saveUser(AppUser user);
	
	public UserRole saveRole(UserRole role);
	
	public void addRoleToUser(String username, String roleName);
	
	public AppUser findUserByUserName(String username);
	
	public void update(AppUser c);
}
