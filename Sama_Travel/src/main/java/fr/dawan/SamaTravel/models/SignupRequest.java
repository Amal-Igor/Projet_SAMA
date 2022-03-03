package fr.dawan.SamaTravel.models;

import fr.dawan.SamaTravel.entities.TypeUser;

public class SignupRequest {

	private String nom;
	private String prenom;
	private String email;
	private String username;
	private String password;
	private TypeUser typeUser;

	public SignupRequest() {
		super();
	}

	public SignupRequest(String nom, String prenom, String email, String username, String password, TypeUser typeUser) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.password = password;
		this.typeUser = TypeUser.CLIENT;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypeUser getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}
	
	
	
}
