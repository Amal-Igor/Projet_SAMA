package fr.dawan.SamaTravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.models.AuthenticationRequest;
import fr.dawan.SamaTravel.models.AuthenticationResponse;
import fr.dawan.SamaTravel.service.IUserService;
import fr.dawan.SamaTravel.service.AppUserDetailsService;
import fr.dawan.SamaTravel.utils.JwtUtil;

@RestController
public class UserController {
	
//	@Autowired
//	IUserService userService;
	
	//TODO Implementer ResponseEntity pour éviter de throw exception quand user already exist
//	@PostMapping("/register")
//	public AppUser registerUser(@RequestBody LoginDto loginDto) {
//		
//		
//		//TODO Utiliser WildCard pour envoyé soit string soit AppUser
//		AppUser user = userService.findUserByUserName(loginDto.getUsername());
//		if(user != null) throw new RuntimeException("This user already exists");
//		
//		
//		AppUser appUser = new AppUser();
//		
//		appUser.setUsername(loginDto.getUsername());
//		appUser.setPassword(loginDto.getPassword());
//		userService.saveUser(appUser);
//		
//		//Une fois l'utilisateur enregistré, je lui donne un rôle par défaut
//		userService.addRoleToUser(loginDto.getUsername(), "USER"); 
//		
//		return appUser;
//	}
	
	
	//TODO Verifier le login
	//@PostMapping("/login")
	
	@Autowired
	AppUserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@GetMapping( "/login")
	public String hello() {
		return "Hello World";
	}
	
	
	@GetMapping( "/test1")
	public String zeubi() {
		return "Hello test1";
	}
	
	
	/*
	 * Ce controller va d'une part récupérer le AuthRequest => pour récuperer les infos du front
	 * et elle va retourner le AuthentificationReponse avec le token.
	 * 
	 * Pour authentifier on aussi devoir utiliser l'authentification manager et renvoyer le token
	 */
		@PostMapping("/login")
		public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws Exception{
		try {
			
			//TODO: getUsername?? getEmail??
			authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			// TODO Auto-generated catch block
			throw new Exception("Incorrect username/password", e);
		}
		//On appelle ce service en cas de succès => renvoit le Jwt qu'on construit grace au JWT util
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authRequest.getUsername());
		
		//Ensuite on va injecter le jwt tool de JwtUtil
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt)); //On génère le token via la classe jwtUtil puis on utilse la classe AuthResponse avec le jwt
	}
		
		
	
	
	
	
	

}
