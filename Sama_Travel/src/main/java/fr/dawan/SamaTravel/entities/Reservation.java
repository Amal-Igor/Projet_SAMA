package fr.dawan.SamaTravel.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Reservation extends DbObject {

    private String arrive;
    private String depart;
    private String date;
    private double prix;

    @ManyToOne
    private AppUser users;

    public Reservation() {
        super();
    }

    public Reservation(double prix, String arrive, String depart, String date) {
        super();
        this.arrive = arrive;
        this.depart = depart;
        this.date = date;
        this.prix = prix;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public AppUser getUsers() {
        return users;
    }

    public void setUsers(AppUser users) {
        this.users = users;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Reservation [arrive=" + arrive + ", depart=" + depart + ", date=" + date + ", prix=" + prix + ", users="
                + users + "]";
    }

}
