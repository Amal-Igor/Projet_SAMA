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

//	
//	@Autowired
//	private AuthenticationManager authManager;
//	

	@PostMapping("/signin")
	public ResponseEntity<String> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
			throws Exception {
		AppUser user = userService.findByUsername(authRequest.getUsername());
		
		String reqUsername = authRequest.getUsername();
		String reqPassword = authRequest.getPassword();
		String userUsername = user.getUsername();
		String userPassword = user.getPassword();

		if(user == null) return new ResponseEntity<String>("Nous ne trouvons pas l'User dans la BDD", HttpStatus.NOT_FOUND);
		

		else if(reqPassword == userPassword) {
				 return new ResponseEntity<String>("Vous êtesconnecté", HttpStatus.OK);
				 
		} else return new ResponseEntity<String>("Mauvaise combinaison mdp/user", HttpStatus.NOT_FOUND);
		
	}

//	@PostMapping("/signin")
//	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//	    Authentication authentication = authenticationManager
//	        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//	    SecurityContextHolder.getContext().setAuthentication(authentication);
//	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//	    List<String> roles = userDetails.getAuthorities().stream()
//	        .map(item -> item.getAuthority())
//	        .collect(Collectors.toList());
//	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//	        .body(new UserInfoResponse(userDetails.getId(),
//	                                   userDetails.getUsername(),
//	                                   userDetails.getEmail(),
//	                                   roles));
//	  }

	@PostMapping(value = "/signup", produces = "application/json")
	public ResponseEntity<?> getById(@RequestBody SignupRequest signupRequest) {
		AppUser user = new AppUser(signupRequest.getNom(), signupRequest.getPrenom(), signupRequest.getEmail(),
				signupRequest.getUsername(), signupRequest.getPassword(), signupRequest.getTypeUser());

		// TODO Peaufiner le login - signup avec l'éventualité ou il existe déjà ce
		// petit batar
		userService.saveUser(user);
		return new ResponseEntity<String>("Utilisateur enregistré ", HttpStatus.OK);
	}

}

//@PostMapping("/signup")
//public ResponseEntity<AppUser>registerUser(@RequestBody AuthenticationRequest authRequest)throws Exception{
////TODO Utiliser WildCard pour envoyé soit string soit AppUser
//AppUser user = userService.findByUsername(authRequest.getUsername());
//if(user != null) throw new RuntimeException("This user already exists");
//
//
//AppUser appUser = new AppUser();
//
//appUser.setUsername(authRequest.getUsername());
//appUser.setPassword(authRequest.getPassword());
//userService.saveUser(appUser);
//
////Une fois l'utilisateur enregistré, je lui donne un rôle par défaut
//
//return ResponseEntity<AppUser>(appUser, HttpStatus.ACCEPTED);
//
//}
