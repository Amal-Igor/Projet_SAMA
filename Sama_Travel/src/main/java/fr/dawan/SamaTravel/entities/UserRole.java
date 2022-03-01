package fr.dawan.SamaTravel.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/*
 * TODO Verifier appRole
 * CLasse oblgiatoire pour pouvoir la gestion des Rôles Spring Secuiry --> pour pouvoir mapper GrantedAuthroties et le persisteer
 */

@Entity
public class UserRole {
	
	@Id 
	@GeneratedValue
	private Integer id;
	
	
	private String roleName;
	
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public UserRole() {
		super();
	}



	public UserRole(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	
	
	
	
	
}
