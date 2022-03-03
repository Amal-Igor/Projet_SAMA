package fr.dawan.SamaTravel.entities;

import javax.persistence.Entity;

@Entity
public class AppUserRole extends DbObject{
	
	
	private String name;

	public AppUserRole() {
		super();
	}

	public AppUserRole(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	

	
	
	
}
