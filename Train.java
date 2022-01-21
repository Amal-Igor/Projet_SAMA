package fr.dawan.SamaTravel.entities;

public class Train {
	
	private int id;
	private int nombrePlaces;
	
	public Train() {
		super();
	}

	public Train(int nombrePlaces) {
		super();
		this.nombrePlaces = nombrePlaces;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}   

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", nombrePlaces=" + nombrePlaces + "]";
	}
	
	
	
	

}
