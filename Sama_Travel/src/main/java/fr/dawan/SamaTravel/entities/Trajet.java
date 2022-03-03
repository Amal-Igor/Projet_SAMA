package fr.dawan.SamaTravel.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Trajet extends DbObject{


	private String gareDepart;
	private String gareArrivee;
	private Date heureDepart;
	private Date heureArrivee;

	@ManyToMany(mappedBy = "trajets", cascade = CascadeType.ALL)
	private List<Gare> gares;

	@ManyToMany(mappedBy = "trajets", cascade = CascadeType.ALL)
	private List<Reservation> reservations;

	public Trajet() {
		super();
		gares = new ArrayList<Gare>();
		reservations = new ArrayList<Reservation>();
	}

	public Trajet(String gareDepart, String gareArrivee, Date heureDepart, Date heureArrivee) {
		super();
		this.gareDepart = gareDepart;
		this.gareArrivee = gareArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		gares = new ArrayList<Gare>();
		reservations = new ArrayList<Reservation>();
	}


	public String getGareDepart() {
		return gareDepart;
	}

	public void setGareDepart(String gareDepart) {
		this.gareDepart = gareDepart;
	}

	public String getGareArrivee() {
		return gareArrivee;
	}

	public void setGareArrivee(String gareArrivee) {
		this.gareArrivee = gareArrivee;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public List<Gare> getGares() {
		return gares;
	}

	public void setGares(List<Gare> gares) {
		this.gares = gares;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Trajet [ gareDepart=" + gareDepart + ", gareArrivee=" + gareArrivee + ", heureDepart="
				+ heureDepart + ", heureArrivee=" + heureArrivee + ", placesReservees=" + ", placesDisponibles="
				+ ", gares=" + gares + ", reservations=" + reservations + "]";
	}

}
