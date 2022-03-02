package fr.dawan.SamaTravel.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends AppUser {

	private Date dateNaissance;
	private String adressePostale;
	private String telephone;
	private int pointsMiles;

	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Reservation> reservations;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String email, String username, String password, TypeUser typeUser) {
		super(nom, prenom, email, username, password, typeUser);
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdressePostale() {
		return adressePostale;
	}

	public void setAdressePostale(String adressePostale) {
		this.adressePostale = adressePostale;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getPointsMiles() {
		return pointsMiles;
	}

	public void setPointsMiles(int pointsMiles) {
		this.pointsMiles = pointsMiles;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
