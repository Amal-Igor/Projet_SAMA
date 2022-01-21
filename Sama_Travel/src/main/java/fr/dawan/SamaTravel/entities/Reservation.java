package fr.dawan.SamaTravel.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int prix;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Trajet> trajets;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private List<User> user;
	
	public Reservation() {
		super();
		trajets = new ArrayList<Trajet>();
		user = new ArrayList<User>();
	}

	public Reservation(int prix) {
		super();
		this.prix = prix;
		trajets = new ArrayList<Trajet>();
		user = new ArrayList<User>();
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id) { 
		this.id = id; 
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", prix=" + prix + ", trajets=" + trajets + ", user=" + user + "]";
	}

}
