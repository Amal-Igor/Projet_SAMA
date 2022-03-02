//package fr.dawan.SamaTravel.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import fr.dawan.SamaTravel.entities.AppUser;
//import fr.dawan.SamaTravel.models.AuthenticationRequest;
//import fr.dawan.SamaTravel.service.IAppUserService;
//
//@RestController
//public class UserController {
//	
////	@Autowired
////	IUserService userService;
//	
//	//TODO Implementer ResponseEntity pour éviter de throw exception quand user already exist
////	@PostMapping("/register")
////	public AppUser registerUser(@RequestBody LoginDto loginDto) {
////		
////		
////		//TODO Utiliser WildCard pour envoyé soit string soit AppUser
////		AppUser user = userService.findUserByUserName(loginDto.getUsername());
////		if(user != null) throw new RuntimeException("This user already exists");
////		
////		
////		AppUser appUser = new AppUser();
////		
////		appUser.setUsername(loginDto.getUsername());
////		appUser.setPassword(loginDto.getPassword());
////		userService.saveUser(appUser);
////		
////		//Une fois l'utilisateur enregistré, je lui donne un rôle par défaut
////		userService.addRoleToUser(loginDto.getUsername(), "USER"); 
////		
////		return appUser;
////	}
//	
//
//	//TODO Quel Service
////	@Autowired
////	IAppUserService userService;
//	
//	
//	@Autowired
//	private AuthenticationManager authManager;
//	
////	@GetMapping( "/login")
////	public String hello() {
////		return "Hello World";
////	}
////	
//
//	
//	
//	/*
//	 * Ce controller va d'une part récupérer le AuthRequest => pour récuperer les infos du front
//	 * et elle va retourner le AuthentificationReponse avec le token.
//	 * 
//	 * Pour authentifier on aussi devoir utiliser l'authentification manager et renvoyer le token
//	 */
//		@PostMapping(value="/login")
//		public ResponseEntity<String> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws Exception{
//			System.out.println("Je suis dans le controller login");
////			AppUser user = userService.findUserByUsername(authRequest.getUsername());
////			
////			if(user == null) {
////				return new ResponseEntity<String>("Nous ne trouvons pas l'User dans la BDD", HttpStatus.NOT_FOUND);
////			}
////			
//			return new ResponseEntity<String>("Vous êtes connecté", HttpStatus.OK);
//			
//			
//	}
//		
//		
//		
//		
//	
//	
//	
//	
//	
//
//}
