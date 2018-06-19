package cpoa_planning;

import java.util.*;

public class TypeFilm {
   private int ID_type;
   private String nom_type;
    
   private ArrayList<Film> films;
   private ArrayList<Jure> jury;
   private ArrayList<Salle> salles;

    public ArrayList<Jure> getJury() {
        return jury;
    }

    public void setJury(ArrayList<Jure> Jury) {
        this.jury = Jury;
    }

    public TypeFilm(int ID_type, String nom_type) {
        this.ID_type = ID_type;
        this.nom_type = nom_type;
        salles = new ArrayList<Salle>();
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
    
    public void AddSalle(Salle s){
        this.salles.add(s);
    }

    public ArrayList<Salle> GetSalles() {
        return salles;
    }
    
    
}