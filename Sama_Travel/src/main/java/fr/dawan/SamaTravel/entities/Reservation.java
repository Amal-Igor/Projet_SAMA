package fr.dawan.SamaTravel.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Reservation extends DbObject {

    private int prix;

    @ManyToOne(targetEntity = AppUser.class, cascade = CascadeType.ALL)
    private AppUser users;

    public Reservation() {
        super();
    }

    public Reservation(int prix) {
        super();
        this.prix = prix;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public AppUser getUsers() {
        return users;
    }

    public void setUsers(AppUser users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Reservation[ prix=" + prix + ", user=" + users + "]";
    }

}
