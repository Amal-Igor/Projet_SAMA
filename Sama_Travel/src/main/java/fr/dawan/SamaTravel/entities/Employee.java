package fr.dawan.SamaTravel.entities;

import org.springframework.stereotype.Component;

@Component
public class Employee extends User{ 
	
	private String role;

	public Employee() {
		super();
	}

	public Employee(String role) {
		super();
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [role=" + role + "]";
	}
	
	
 
}
