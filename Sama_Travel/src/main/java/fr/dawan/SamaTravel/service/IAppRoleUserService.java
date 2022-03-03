package fr.dawan.SamaTravel.service;

import fr.dawan.SamaTravel.entities.AppUserRole;

public interface IAppRoleUserService {
	

		AppUserRole findByName(String rolename);
	
	
}
