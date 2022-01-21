package fr.dawan.SamaTravel.entities;

public class Reservation {
	
	private int id;
	//private int idTrajet;
	//private int idUser;
	private int prix;
	
	public Reservation() {
		super();
	}

	public Reservation(int prix) {
		super();
		this.prix = prix;
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

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", prix=" + prix + "]";
	}
	
	
	
	
	

}
