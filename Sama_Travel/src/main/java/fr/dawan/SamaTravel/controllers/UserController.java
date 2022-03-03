package fr.dawan.SamaTravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.entities.Client;
import fr.dawan.SamaTravel.entities.TypeUser;
import fr.dawan.SamaTravel.models.AuthenticationRequest;
import fr.dawan.SamaTravel.models.SignupRequest;
import fr.dawan.SamaTravel.service.IAppUserService;

@RestController
public class UserController {

	@Autowired
	IAppUserService userService;

	@PostMapping("/login")
	public ResponseEntity<String> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
			throws Exception {
		AppUser user = userService.findByUsername(authRequest.getUsername());
		
		String reqUsername = authRequest.getUsername();
		String reqPassword = authRequest.getPassword();
		String userUsername = user.getUsername();
		String userPassword = user.getPassword();

		if(user.equals(null)) {
		    return new ResponseEntity<String>("Nous ne trouvons pas l'User dans la BDD", HttpStatus.NOT_FOUND);
		}
        else if(reqPassword.equals(userPassword) && reqUsername.equals(userUsername)) {
                 return new ResponseEntity<String>("Vous êtes connecté", HttpStatus.OK);
        } else return new ResponseEntity<String>("Mauvaise combinaison mdp/user", HttpStatus.NOT_FOUND);
    }


	@PostMapping(value = "/signup", produces = "application/json")
	public ResponseEntity<?> getById(@RequestBody SignupRequest signupRequest) {
		AppUser user = new AppUser(signupRequest.getNom(), signupRequest.getPrenom(), signupRequest.getEmail(),
				signupRequest.getUsername(), signupRequest.getPassword(), signupRequest.getTypeUser());

		// TODO Peaufiner le login - signup avec l'éventualité ou il existe déjà ce
		// petit batar
		if(!user.equals(null) ) {
		    throw new RuntimeException("This user already exists");
		} else {
		    userService.saveUser(user);
		}
		
		
		return new ResponseEntity<String>("Utilisateur enregistré ", HttpStatus.OK);
	}

}