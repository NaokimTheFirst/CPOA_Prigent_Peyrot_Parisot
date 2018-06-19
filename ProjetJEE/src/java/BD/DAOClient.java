
package BD;
import Beans.Client;
import java.sql.*;

public class DAOClient {
    
    //Fonction qui transform un bean Client en un Client de BD
    public static boolean TransformClient(Client c){
        if(CheckBD(c.getNom(),c.getPrenom()) == true){                          //Si le client existe déjà
            return false;                                                       //Quitte la fonction
        }
        AddClientBD(c);
        
        return true;
    }
    
    //Fonction qui vérifie si le client n'existe pas déjà
    public static boolean CheckBD(String nom, String prenom){
        boolean b = false;
        String requete = "Select * FROM CPOACLIENT WHERE NOM = '"+nom+"' AND PRENOM = '"+prenom+"'";
        ResultSet result = BD.FaireRequete(requete);
        try{
            while(result.next()){
                b = true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        BD.CloseConnection();
        return b;
    }
    
    //Fonction qui ajoute un client à la BD
    private static void AddClientBD(Client c){
        String requete = "INSERT INTO CPOACLIENT (NOM,PRENOM,FONCTION)"
                + " VALUES ('"+c.getNom()+"','"+c.getPrenom()+"','"+c.getFonction()+"')";
        ResultSet result = BD.FaireRequete(requete);
        BD.CloseConnection();
    }
    
    //Fonction qui crée un Bean Client en le copiant depuis la Base de Donnée
    public static Client GetClient(String nom, String prenom){
        Client client = new Client();
        String requete = "Select * FROM CPOACLIENT WHERE NOM = '"+nom+"' AND PRENOM = '"+prenom+"'";
        ResultSet result = BD.FaireRequete(requete);
        try{
            result.next();
            client.setNom(result.getString("NOM"));
            client.setPrenom(result.getString("PRENOM"));
            client.setFonction(result.getString("FONCTION"));
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        BD.CloseConnection();
        return client;
    }
}
