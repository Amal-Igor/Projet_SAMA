package fr.dawan.SamaTravel.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class AppUserRole extends DbObject {

    private String name;

    public AppUserRole() {
        super();
    }

    public AppUserRole(String name) {
        super();
        this.name = name;
    }

    public String getRole() {
        return name;
    }

    public void setRole(String name) {
        this.name = name;
    }

//TODO VERIFIER POUR LE CONSTRUCTEUR

}