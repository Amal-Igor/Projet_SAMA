package fr.dawan.SamaTravel.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends AppUser {

    public Admin() {
        super();
    }

    public Admin(String nom, String prenom, String email, String username, String password, TypeUser typeUser) {
        super(nom, prenom, email, username, password, typeUser);
    }

}
