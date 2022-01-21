package fr.dawan.SamaTravel.entities;

import java.sql.Date;

public class Trajet {
	
	private int id;
	private String gareDepart;
	private String gareArrivee;
	private Date heureDepart;  
	private Date heureArrivee;
	// private int idTrain
	private int placesReservees;
	private int placesDisponibles;
	
	public Trajet() {
		super();
	}

	public Trajet(String gareDepart, String gareArrivee, Date heureDepart, Date heureArrivee, int placesReservees,
			int placesDisponibles) {
		super();
		this.gareDepart = gareDepart;
		this.gareArrivee = gareArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
		this.placesReservees = placesReservees;
		this.placesDisponibles = placesDisponibles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getPlacesReservees() {
		return placesReservees;
	}

	public void setPlacesReservees(int placesReservees) {
		this.placesReservees = placesReservees;
	}

	public int getPlacesDisponibles() {
		return placesDisponibles;
	}

	public void setPlacesDisponibles(int placesDisponibles) {
		this.placesDisponibles = placesDisponibles;
	}

	@Override
	public String toString() {
		return "Trajet [id=" + id + ", gareDepart=" + gareDepart + ", gareArrivee=" + gareArrivee + ", heureDepart="
				+ heureDepart + ", heureArrivee=" + heureArrivee + ", placesReservees=" + placesReservees
				+ ", placesDisponibles=" + placesDisponibles + "]";
	}
	
	
	
	
	

}
