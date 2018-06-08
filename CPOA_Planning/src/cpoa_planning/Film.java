package cpoa_planning;

import bd.Bd;
import java.sql.ResultSet;
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
    }
    
        //Fonction qui ajoute un film à la BD à partir d'un Objet
        public boolean AjouterFilm(Film f){
             // TODO code application logic here
             String requete = "INSERT INTO FILM (IDFILM,TITRE,GENRE,REAL,DUREE) VALUES ('0','"+titre+"','"+genre+"','"+real+"','"+duree+"')";
             
             ResultSet result = Bd.FaireRequete(requete);
       
        try{
            if(result !=null){
                System.out.println("Insertion réussi");
                return true;
            } else {
                System.out.println("Insertion échoué");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }            
            return false;
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