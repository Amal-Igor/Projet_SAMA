package fr.dawan.SamaTravel.service;

import java.util.List;

import fr.dawan.SamaTravel.entities.AppUser;
import fr.dawan.SamaTravel.entities.AppUserRole;
import fr.dawan.SamaTravel.entities.Reservation;
import fr.dawan.SamaTravel.models.SignupRequest;
import fr.dawan.SamaTravel.models.UpdateUserDto;

public interface IAppUserService {
	
	
	
	//Methode permettant de retourner un utilisateur
	public AppUser findByUsername(String username);

	public void saveUser(AppUser appUser);
	
	public void updateUser(String username, UpdateUserDto updateDto);
	
	public void addRoleToUser(String username, String roleName);

	AppUserRole saveRole(AppUserRole role);
	
	public void deleteUserByUsername(String username);
	
	List<AppUser> getAllAppUser();
	
	List<String> getUserInformations(String username);
	
	public void addReservationToUser(String username, Reservation resa);
	
	List<Reservation> getReservations(String username);

	
}
