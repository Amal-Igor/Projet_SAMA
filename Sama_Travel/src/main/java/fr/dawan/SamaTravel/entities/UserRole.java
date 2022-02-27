package fr.dawan.SamaTravel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
