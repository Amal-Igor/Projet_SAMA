package fr.dawan.SamaTravel.entities;

public class Gare {
	
	private int id;
	private String ville;
	private int codePostal;
	
	public Gare() {
		super();
	}

	public Gare(String ville, int codePostal) {
		super();
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
  
	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Gare [id=" + id + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}
	
	
	
	

}
