package BD;

import java.sql.ResultSet;
import BD.*;
import Beans.*;
import java.util.ArrayList;

public class DAODispo {
    
    public static void ChangeChambreHotel(String nomH, int jour){
        String requete = "SELECT CHAMBRES FROM DISPO WHERE NOMH = '"+nomH+"' AND JOUR ='"+jour+"'";
        ResultSet result = BD.FaireRequete(requete);
        int chambre = 0;
        try{
            result.next();
            chambre = result.getInt("CHAMBRES") - 1;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        requete = "UPDATE DISPO SET CHAMBRES ='"+chambre+"' WHERE NOMH = '"+nomH+"' AND JOUR = '"+jour+"'";
        BD.FaireRequete(requete);
        BD.CloseConnection();

        return;
    }
    
    
    //Fonction qui ajoute une disponibilité à un hotel, un jour donné
    public static void AddDispo(Dispo d){
        String requete = "INSERT INTO DISPO (NOMH,JOUR,CHAMBRES) VALUES ('"+d.getNomH()+"','"+ d.getJour()+"','"+d.getChambres()+"')";
        ResultSet result = BD.FaireRequete(requete);
        BD.CloseConnection();
    }
    
    public static ArrayList<Hebergement> GetHotels(int jour, String statut){
        ArrayList<Hebergement> Hotels = new ArrayList<Hebergement>();
        
        String requete = "SELECT NOMH FROM DISPO WHERE JOUR ="+jour+" AND CHAMBRES > 0";
        ResultSet result = BD.FaireRequete(requete);

        try{
            while(result.next()){
                Hebergement h = GetHebergement(result.getString("NOMH"),statut);
                if(h.getNomhebergement() != null){
                    Hotels.add(h);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        BD.CloseConnection();
        return Hotels;
    }
    
    private static Hebergement GetHebergement(String nom, String statut){
        String requete = "SELECT * FROM HEBERGEMENT WHERE NOMHEBERGEMENT ='"+nom+"' AND (CIBLE='"+statut+"' OR CIBLE = 'NEUTRE')" ;
        ResultSet result = BD.FaireRequete(requete);
        Hebergement h = new Hebergement();
        try{
            
            result.next();
            h.setNomhebergement(result.getString("NOMHEBERGEMENT"));
            h.setType(result.getString("TYPE"));
            h.setAdresse(result.getString("ADRESSE"));
            h.setServices(result.getString("SERVICES"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        BD.CloseConnection();
        return h;
    }
}
