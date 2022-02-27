package fr.dawan.SamaTravel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.dto.LoginDto;
import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/register")
	public AppUser registerUser(@RequestBody LoginDto loginDto) {
		
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
	

}
