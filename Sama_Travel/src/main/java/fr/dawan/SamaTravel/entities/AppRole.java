package fr.dawan.SamaTravel.entities;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Data @AllArgsConstructor @NoArgsConstructor
public class AppRole extends DbObject{   
    
    /*
     * Pas d'association, car Je n'ai pas besoin pour un role de savoir 
     * tous les utilisateurs qui ont ce role
     */
    private String roleName;
    
}