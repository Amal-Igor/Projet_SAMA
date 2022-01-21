package fr.dawan.SamaTravel.entities;

import java.sql.Date;

public class Client extends User{
	
	private Date dateNaissance;
	private String adresse;
	private String telephone;  
	private int pointsMiles;
	
	public Client() {
		super();
	}

	public Client(Date dateNaissance, String adresse, String telephone, int pointsMiles) {
		super();
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.pointsMiles = pointsMiles;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	@Override
	public String toString() {
		return "Client [dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", telephone=" + telephone
				+ ", pointsMiles=" + pointsMiles + "]";
	}
	
	
	
	
	

}
