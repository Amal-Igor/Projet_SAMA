package fr.dawan.SamaTravel.entities;

import java.util.Collection;

public class Admin extends AppUser{

	public Admin() {
		super();
	}

	public Admin(String nom, String prenom, String email, String username, String password, TypeUser typeUser,
			Collection<AppUserRole> roles) {
		super(nom, prenom, email, username, password, typeUser, roles);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
