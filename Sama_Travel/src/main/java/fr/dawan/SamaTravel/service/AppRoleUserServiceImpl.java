package fr.dawan.SamaTravel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.SamaTravel.entities.AppUserRole;
import fr.dawan.SamaTravel.repositories.AppUserRoleRepository;


@Service
public class AppRoleUserServiceImpl implements IAppRoleUserService {
	
	@Autowired
	AppUserRoleRepository roleRepo;
	
	
	@Override
	public AppUserRole findByName(String rolename) {
		AppUserRole role= findByName(rolename);
		return role;
	}

}
