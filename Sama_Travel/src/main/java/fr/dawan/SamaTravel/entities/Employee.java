package fr.dawan.SamaTravel.entities;

import org.springframework.stereotype.Component;

@Component
public class Employee extends AppUser{ 
	
	private String poste;

	public Employee() {
		super();
	}

	public Employee(String poste) {
		super();
		this.poste = poste;
	}

	public String getposte() {
		return poste;
	}

	public void setposte(String poste) {
		this.poste = poste;
	}

	@Override
	public String toString() {
		return "Employee [poste=" + poste + "]";
	}

}
