package fr.dawan.SamaTravel.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("employe")
public class Employee extends AppUser {

    private String poste;

    public Employee() {
    }

    public Employee(String poste) {
        super();
        this.poste = poste;
    }

    public Employee(String nom, String prenom, String email, String username, String password,
            List<Reservation> reservations, Collection<AppUserRole> role) {
        super(nom, prenom, email, username, password, reservations, role);
    }

    public String getposte() {
        return poste;
    }

    public void setposte(String poste) {
        this.poste = poste;
    }

    @Override
    public String toString() {
        return "Employee [poste=" + poste + "]";
    }

}
