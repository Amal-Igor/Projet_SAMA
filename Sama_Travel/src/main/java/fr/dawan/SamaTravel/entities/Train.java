package fr.dawan.SamaTravel.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nombrePlaces;
	
	@OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
	private List<Trajet> trajets;
	
	public Train() {
		super();
		trajets = new ArrayList<Trajet>();
	}

	public Train(int nombrePlaces) {
		super();
		this.nombrePlaces = nombrePlaces;
		trajets = new ArrayList<Trajet>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}   

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", nombrePlaces=" + nombrePlaces + ", trajets=" + trajets + "]";
	}

}
