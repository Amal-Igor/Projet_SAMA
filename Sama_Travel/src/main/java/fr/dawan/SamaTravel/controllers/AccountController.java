package fr.dawan.SamaTravel.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.SamaTravel.entities.Reservation;
import fr.dawan.SamaTravel.models.UpdateUserDto;
import fr.dawan.SamaTravel.service.IAppUserService;
import fr.dawan.SamaTravel.service.IReservationService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	IAppUserService userService;
	
	@Autowired
	IReservationService reservationService;
	
	
	@GetMapping("/{username}")
	public List<String> getInfosFromUsers(@PathVariable String username, HttpServletResponse res) throws IOException{
		
		if(userService.findByUsername(username) == null) {
			res.setStatus(404);
			res.getWriter().write("Le user n'exsite pas");
		}
		
		List<String> lst = new ArrayList<>();
		lst = userService.getUserInformations(username);
		return lst;
	}
	
	@PutMapping("/{username}")
	public void updateUserInfos(@PathVariable String username, @RequestBody UpdateUserDto updateDto) {
		userService.updateUser(username, updateDto);
	}
	
	//TODO Implementer controller pour modifier infos user
	
	
	@PostMapping("/{username}/save")
	public void saveReserveration(@PathVariable String username, @RequestBody Reservation resa) {
		reservationService.addReservation(resa);
		userService.addReservationToUser(username, resa);
		
	}
	
	@GetMapping("/{username}/reservation")
	public List<Reservation> getReservartionFromuser(@PathVariable String username){
		List<Reservation> lst = userService.getReservations(username);
		
		return lst;
		
	}
	
	
	
	
	
}
