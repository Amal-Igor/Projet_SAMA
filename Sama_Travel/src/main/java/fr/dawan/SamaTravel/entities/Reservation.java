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
	
	@ManyToOne(targetEntity = Client.class, cascade = CascadeType.ALL)
	private List<Client> users;
	
	public Reservation() {
		super();
		trajets = new ArrayList<Trajet>();
		users = new ArrayList<Client>();
	}

	public Reservation(int prix) {
		super();
		this.prix = prix;
		trajets = new ArrayList<Trajet>();
		users = new ArrayList<Client>();
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



	public List<Client> getUsers() {
		return users;
	}

	public void setUsers(List<Client> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", prix=" + prix + ", trajets=" + trajets + ", user=" + users + "]";
	}

}
