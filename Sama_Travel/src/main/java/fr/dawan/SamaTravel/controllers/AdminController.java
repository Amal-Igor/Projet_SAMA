package fr.dawan.SamaTravel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.service.IAppUserService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	IAppUserService userService;
	
	
	
	@GetMapping(value = "/users", produces = "application/json")
	public  List<AppUser> getAllUser(){
		List<AppUser> userLst = userService.getAllAppUser();
		return userLst;
	}
}
