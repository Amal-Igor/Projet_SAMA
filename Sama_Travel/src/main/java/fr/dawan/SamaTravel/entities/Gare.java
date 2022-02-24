package fr.dawan.SamaTravel.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Gare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ville;
	private int codePostal;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Trajet> trajets;
	
	public Gare() {
		super();
		trajets = new ArrayList<Trajet>();
	}

	public Gare(String ville, int codePostal) {
		super();
		this.ville = ville;
		this.codePostal = codePostal;
		trajets = new ArrayList<Trajet>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
  
	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	@Override
	public String toString() {
		return "Gare [id=" + id + ", ville=" + ville + ", codePostal=" + codePostal + ", trajets=" + trajets + "]";
	}


	
	
	

}
