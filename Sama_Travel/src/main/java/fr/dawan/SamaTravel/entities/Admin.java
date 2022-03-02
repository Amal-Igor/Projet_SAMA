package fr.dawan.SamaTravel.entities;

public class Admin extends AppUser{

	public Admin() {
		super();
	}

	public Admin(String nom, String prenom, String email, String username, String password, TypeUser typeUser) {
		super(nom, prenom, email, username, password, typeUser);
	}
	
	
}
