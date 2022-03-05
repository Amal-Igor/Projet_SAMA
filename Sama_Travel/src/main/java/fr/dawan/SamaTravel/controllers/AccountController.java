package fr.dawan.SamaTravel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.service.IAppUserService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	IAppUserService userService;
	
	
	@GetMapping("/{username}")
	public List<String> getInfosFromUsers(@PathVariable String username){
		List<String> lst = new ArrayList<>();
		lst = userService.getUserInformations(username);
		return lst;
	}
}
