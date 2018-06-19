package cpoa_planning;

import java.util.*;

public class Salle {
   private int ID_salle;
   private String name;
   private int places;
   
   public ArrayList<Projection> projection;

    public Salle(int ID_salle, String name, int places) {
        this.ID_salle = ID_salle;
        this.name = name;
        this.places = places;
        projection = new ArrayList<Projection>();
    }

    public int getID_salle() {
        return ID_salle;
    }

    public String GetName() {
        return name;
    }
   
   //Ajoute une projection à la liste
    public void Add_Projection(Projection p) {
        projection.add(p);
    }

}