package fr.dawan.SamaTravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.dto.LoginDto;
import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	
	//TODO Implementer ResponseEntity pour éviter de throw exception quand user already exist
	@PostMapping("/register")
	public AppUser registerUser(@RequestBody LoginDto loginDto) {
		
		
		//TODO Utiliser WildCard pour envoyé soit string soit AppUser
		AppUser user = userService.findUserByUserName(loginDto.getUsername());
		if(user != null) throw new RuntimeException("This user already exists");
		
		
		AppUser appUser = new AppUser();
		
		appUser.setUsername(loginDto.getUsername());
		appUser.setPassword(loginDto.getPassword());
		userService.saveUser(appUser);
		
		//Une fois l'utilisateur enregistré, je lui donne un rôle par défaut
		userService.addRoleToUser(loginDto.getUsername(), "USER"); 
		
		return appUser;
	}
	
	
	//TODO Verifier le login
	//@PostMapping("/login")
	
	
	

}
