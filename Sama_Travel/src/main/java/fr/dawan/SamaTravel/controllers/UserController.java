package fr.dawan.SamaTravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.models.SignupRequest;
import fr.dawan.SamaTravel.service.IAppUserService;

@RestController
public class UserController {

	@Autowired
	IAppUserService userService;

	@Autowired
	BCryptPasswordEncoder bcrypt;

	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<?> getById(@RequestBody SignupRequest signupRequest) {

		// Verification si le user
		AppUser user = userService.findByUsername(signupRequest.getUsername());

		if (user != null) {
			return new ResponseEntity<String>("Utilisateur déjà présent dans la BDD", HttpStatus.UNAUTHORIZED);
		}

		AppUser userToAdd = new AppUser();
		userToAdd.setEmail(signupRequest.getEmail());
		userToAdd.setNom(signupRequest.getNom());
		userToAdd.setPassword(signupRequest.getPassword());
		userToAdd.setPrenom(signupRequest.getPrenom());
		userToAdd.setUsername(signupRequest.getUsername());

		userService.saveUser(userToAdd);
		userService.addRoleToUser(signupRequest.getUsername(), "USER");
		// On assigne le rôle après l'enregistrement
		return new ResponseEntity<AppUser>(userToAdd, HttpStatus.OK);
	}

}

