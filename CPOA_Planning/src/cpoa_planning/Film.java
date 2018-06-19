package cpoa_planning;

import java.util.*;

public class Film {
   private int ID_film;
   private String titre;
   private String genre;
   private String real;
   private int duree;
   private int IdCategorie;
   private ArrayList<Projection> projection;

    public Film(int i,String titre, String genre, String real, int duree, int IDC) {
        this.ID_film = i;
        this.titre = titre;
        this.genre = genre;
        this.real = real;
        this.duree = duree;
        this.IdCategorie =IDC;
        projection = new ArrayList<Projection>();
    }
    
    //Ajoute une projection à la liste
    public void Add_Projection(Projection p) {
        projection.add(p);
    }

    public int getID_film() {
        return ID_film;
    }

    public String getTitre() {
        return titre;
    }

    public String getGenre() {
        return genre;
    }

    public String getReal() {
        return real;
    }

    public int getDuree() {
        return duree;
    }

    public int getIdCategorie() {
        return IdCategorie;
    }

    public ArrayList<Projection> getProjection() {
        return projection;
    }
        
        
    }