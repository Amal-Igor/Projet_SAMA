package fr.dawan.SamaTravel.entities;


import javax.persistence.Entity;

import org.springframework.stereotype.Component;


@Entity
public class Reservation extends DbObject{
	
	
	
	private String prix;
	private String depart;
	private String arrive;
	private String date;
	
	
	
	public Reservation() {
		super();
	}




	public Reservation(String prix, String depart, String arrive, String date) {
		super();
		this.prix = prix;
		this.depart = depart;
		this.arrive = arrive;
		this.date = date;
	}




	public String getPrix() {
		return prix;
	}




	public void setPrix(String prix) {
		this.prix = prix;
	}




	public String getDepart() {
		return depart;
	}




	public void setDepart(String depart) {
		this.depart = depart;
	}




	public String getArrive() {
		return arrive;
	}




	public void setArrive(String arrive) {
		this.arrive = arrive;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	

}
