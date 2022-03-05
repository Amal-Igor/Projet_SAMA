package fr.dawan.SamaTravel.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DiscriminatorOptions;

//TODO Vérifier si on crée la classe AppUser en surcouche d'une classeUser????

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur", discriminatorType = DiscriminatorType.STRING, length = 30)
@DiscriminatorOptions(force = true)
public class AppUser extends DbObject {

    private String nom;
    private String prenom;

    @Column
    private String email;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinColumn(name="rolename")
    private Collection<AppUserRole> roles = new ArrayList<>();

    public AppUser() {
        super();
        reservations = new ArrayList<>();
    }

    // TODO TEST

    public AppUser(String nom, String prenom, String email, String username, String password,
            List<Reservation> reservations, Collection<AppUserRole> role) {
        super();
        reservations = new ArrayList<>(); 
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<AppUserRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppUserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "AppUser [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", username=" + username
                + ", password=" + password + "roles= ";
    }

}
