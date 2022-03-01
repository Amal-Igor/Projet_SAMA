package fr.dawan.SamaTravel.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//TODO Vérifier si on crée la classe AppUser en surcouche d'une classeUser????

@Entity
public class AppUser {
	
	
//	//TODO Enlever le pete couille
//	@Autowired
//	UserRole userRole; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;  
	private String prenom;
	
	@Column
	private String email;
	
	@Column(unique=true)
	private String username;
	 
	private String password; 
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Reservation> reservations;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="roleName")
	private Collection<UserRole> roles ;
	

	public AppUser() {
		super();
		reservations = new ArrayList<Reservation>();
	}

	public AppUser(String nom, String prenom, String username, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.password = password;
		roles = new ArrayList<>();
		reservations = new ArrayList<Reservation>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Collection<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<UserRole> roles) {
		this.roles = roles;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", reservations=" + reservations + ", r]";
	}
	


}
