package fr.dawan.SamaTravel.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gares")
public class Gare extends DbObject {

    private String ville;
    private String regionAdmin;
    private String stopArea;

    public Gare() {
        super();
        // trajets = new ArrayList<Trajet>();
    }

    public Gare(String ville, String regionAdmin, String stopArea) {
        super();
        this.ville = ville;
        this.regionAdmin = regionAdmin;
        this.stopArea = stopArea;
        // trajets = new ArrayList<Trajet>();
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

    @Override
    public String toString() {
        return "Gare  ville=" + ville + ", regionAdmin=" + regionAdmin + ", stopArea=" + stopArea + "]";
    }

}
