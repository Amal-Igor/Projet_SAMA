package fr.dawan.SamaTravel.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "gares")
public class Gare extends DbObject{
	

	private String ville;
	private String regionAdmin;
	private String stopArea;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Trajet> trajets;
	
	public Gare() {
		super();
		//trajets = new ArrayList<Trajet>();
	}

	public Gare(String ville, String regionAdmin,String stopArea ) {
		super();
		this.ville = ville;
		this.regionAdmin = regionAdmin;
		this.stopArea = stopArea;
		//trajets = new ArrayList<Trajet>();
	}



	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
  
	

	public String getRegionAdmin() {
		return regionAdmin;
	}

	public void setRegionAdmin(String regionAdmin) {
		this.regionAdmin = regionAdmin;
	}


	public String getStopArea() {
		return stopArea;
	}

	public void setStopArea(String stopArea) {
		this.stopArea = stopArea;
	}


	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	@Override
	public String toString() {
		return "Gare  ville=" + ville + ", regionAdmin=" + regionAdmin + ", stopArea=" + stopArea
				+ ", trajets=" + trajets + "]";
	}


}
