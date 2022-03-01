package fr.dawan.SamaTravel.models;


/*
 * 
 * Cette classe permet de définir la réponse que l'on renverra depuis notre controller en cas d'auth successful
 * Donc ici on va devoir renvoyer jwt 
 *
 */

public class AuthenticationResponse {
		
	private String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	
	
}
