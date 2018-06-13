/***********************************************************************
 * Module:  Salle.java
 * Author:  p1623123
 * Purpose: Defines the Class Salle
 ***********************************************************************/

package cpoa_planning;

import java.util.*;

public class Salle {
   private int ID_salle;
   private String name;
   private int places;
   
   public java.util.Collection<Projection> projection;

    public Salle(int ID_salle, String name, int places) {
        this.ID_salle = ID_salle;
        this.name = name;
        this.places = places;
    }

    public int getID_salle() {
        return ID_salle;
    }

    public String GetName() {
        return name;
    }
   
   

}