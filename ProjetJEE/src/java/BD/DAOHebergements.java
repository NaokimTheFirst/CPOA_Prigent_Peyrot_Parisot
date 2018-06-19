/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Beans.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOHebergements {
    //Fonction qui récupère toutes les commandes d'un client
    public static ArrayList<Hebergement> GetAllHeb(Client client){
        String requete = "SELECT * FROM HEBERGEMENT WHERE CLIENT = '"+client.getNom()+"'";
        ResultSet result = BD.FaireRequete(requete);
        
        ArrayList<Hebergement> Hebergements =  new ArrayList<Hebergement>();
        
        try{
            while(result.next()){
                Hebergement c = new Hebergement();
                c.setClient(client);
                c.setNumhebergement(result.getInt("NUMHEBERGEMENT"));
                c.setNomhebergement(result.getString("NOMHEBERGEMENT"));
                c.setType(result.getString("TYPE"));
                c.setAdresse(result.getString("ADRESSE"));
                c.setServices(result.getString("SERVICES"));
                Hebergements.add(c);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        BD.CloseConnection();
        return Hebergements;
    }
     //Fonction qui ajoute un Hotel à la BD
    public static void AddHebergementBD(Hebergement c){
        
        String requete = "INSERT INTO HEBERGEMENT (NUMHEBERGEMENT,NOMHEBERGEMENT,TYPE,ADRESSE,SERVICES,CLIENT)"
                + " VALUES ('"+c.getNumhebergement()+"','"+c.getNomhebergement()  +"','"+c.getType()+"','"+ c.getAdresse()+"','"+c.getServices()+"','"+c.getClient().getNom()+"')";
        
        BD.FaireRequete(requete);
        BD.CloseConnection();
    }
    
    //Fonction qui définit la cible d'un hotel
    public static void SetCibleHotel(String nomHotel, String cible){
        String requete = "UPDATE HEBERGEMENT SET CIBLE ='"+cible+"' WHERE NOMHEBERGEMENT = '"+nomHotel+"'";
        BD.FaireRequete(requete);
        BD.CloseConnection();

        return;
    }
}
