/***********************************************************************
 * Module:  Jure.java
 * Author:  p1623123
 * Purpose: Defines the Class Jure
 ***********************************************************************/

package cpoa_planning;

import java.util.*;

public class Jure {
   private int ID_jure;
   private String nom_jure;
   private boolean president;
   private int IDcategorie;
   private int nb_proj_max_j = 0;

    public Jure(int ID_jure, String nom_jure, boolean president, int c) {
        this.ID_jure = ID_jure;
        this.nom_jure = nom_jure;
        this.president = president;
        this.IDcategorie = c;
    }

    public String getNom_jure() {
        return nom_jure;
    }

    public boolean isPresident() {
        return president;
    }
}