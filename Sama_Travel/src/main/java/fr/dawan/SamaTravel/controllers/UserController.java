package fr.dawan.SamaTravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.entities.AppUserRole;
import fr.dawan.SamaTravel.models.AuthenticationRequest;
import fr.dawan.SamaTravel.models.SignupRequest;
import fr.dawan.SamaTravel.securityconfig.JWTAuthenticationFilter;
import fr.dawan.SamaTravel.service.IAppUserService;

@RestController
public class UserController {

	@Autowired
	IAppUserService userService;

	@Autowired
	BCryptPasswordEncoder bcrypt;


	
	
	
//	@PostMapping("/signin")
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
//			throws Exception {
//		AppUser user = userService.findByUsername(authRequest.getUsername());
//		
//		
//		 
//
//		if (user == null)
//			return new ResponseEntity<String>("Nous ne trouvons pas l'User dans la BDD", HttpStatus.NOT_FOUND);
//
//		else if ((bcrypt.matches(authRequest.getPassword(), user.getPassword()) == true)
//				&& (authRequest.getUsername().equals(user.getUsername()))) {
//			final Authentication authentication = authenticationManager.authenticate(
//	                new UsernamePasswordAuthenticationToken(
//	                		authRequest.getUsername(),
//	                		authRequest.getPassword()
//	                )
//	        );
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//	        
//	        
//			return new ResponseEntity<String>("Vous êtes connecté", HttpStatus.OK);
//		} else
//			return new ResponseEntity<String>("Mauvaise combinaison mdp/user", HttpStatus.NOT_FOUND);
//	}

//	@PostMapping("/login")
//	public ResponseEntity<String> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest)
//			throws Exception {
//		AppUser user = userService.findByUsername(authRequest.getUsername());
//
//		if (user == null)
//			return new ResponseEntity<String>("Nous ne trouvons pas l'User dans la BDD", HttpStatus.NOT_FOUND);
//
//		else if ((bcrypt.matches(authRequest.getPassword(), user.getPassword()) == true)
//				&& (authRequest.getUsername().equals(user.getUsername()))) {
//			return new ResponseEntity<String>("Vous êtes connecté", HttpStatus.OK);
//		} else
//			return new ResponseEntity<String>("Mauvaise combinaison mdp/user", HttpStatus.NOT_FOUND);
//	}

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
		userService.addRoleToUser(signupRequest.getUsername(), "CLIENT");
		// On assigne le rôle après l'enregistrement
		return new ResponseEntity<AppUser>(userToAdd, HttpStatus.OK);
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
