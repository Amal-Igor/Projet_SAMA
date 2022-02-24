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

import org.springframework.stereotype.Component;


@Component
@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int prix;
	
	@ManyToMany(targetEntity = Trajet.class, cascade = CascadeType.ALL)
	private List<Trajet> trajets;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	private List<User> users;
	
	public Reservation() {
		super();
		trajets = new ArrayList<Trajet>();
		users = new ArrayList<User>();
	}

	public Reservation(int prix) {
		super();
		this.prix = prix;
		trajets = new ArrayList<Trajet>();
		users = new ArrayList<User>();
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
		return users;
	}

	public void setUser(List<User> user) {
		this.users = user;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", prix=" + prix + ", trajets=" + trajets + ", user=" + users + "]";
	}

}
