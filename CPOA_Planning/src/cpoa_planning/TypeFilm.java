/***********************************************************************
 * Module:  Type_Film.java
 * Author:  p1623123
 * Purpose: Defines the Class Type_Film
 ***********************************************************************/

package cpoa_planning;

import java.util.*;

public class TypeFilm {
   private int ID_type;
   private String nom_type;
    
   public ArrayList<Film> films;

    public TypeFilm(int ID_type, String nom_type) {
        this.ID_type = ID_type;
        this.nom_type = nom_type;
    }

    public int getID_type() {
        return ID_type;
    }

    public String getNom_type() {
        return nom_type;
    }

    public ArrayList<Film> getFilm() {
        return films;     
    }
    
    public void SetListFilm(ArrayList<Film> newList){
        this.films = newList;
    }
    
    
   
   
}