
package BD;

import Beans.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DAOCommandes {
    
    //Fonction qui récupère toutes les commandes d'un client
    public static ArrayList<Commande> GetAllCommands(Client client){
        String requete = "SELECT * FROM JEECOMMANDE WHERE IDCLIENT = '"+client.getNom()+"'";
        ResultSet result = BD.FaireRequete(requete);
        
        ArrayList<Commande> commandes =  new ArrayList<Commande>();
        
        try{
            while(result.next()){
                Commande c = new Commande();
                c.setClient(client);
                c.setIdCommande(result.getInt("IDCOMMANDE"));
                c.setStatutLivraison(result.getString("STATUT"));
                c.setMontant(result.getFloat("MONTANT"));
                c.setDate(result.getDate("DATECOMMANDE").toString());
                commandes.add(c);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        BD.CloseConnection();
        return commandes;
    }

    //Fonction qui ajoute un client à la BD
    public static void AddClientBD(Commande c){
        String date = DateToString();
        String requete = "INSERT INTO JEECOMMANDE (IDCLIENT,DATECOMMANDE,STATUT,MONTANT,IDCOMMANDE)"
                + " VALUES ('"+c.getClient().getNom()+"',"+ date +",'En Cours','"+c.getMontant()+"','"+GetNextId()+"')";
        ResultSet result = BD.FaireRequete(requete);
        BD.CloseConnection();
    }
    
    //Fonction qui récupère l'indice suivant disponible
    private static int GetNextId(){
        int nextid = 0;
        String requete = "SELECT IDCOMMANDE FROM JEECOMMANDE ORDER BY IDCOMMANDE";
        ResultSet result = BD.FaireRequete(requete);
        try{
            while(result.next()){
                nextid = result.getInt("IDCOMMANDE") +1 ;
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        BD.CloseConnection();
        
        return nextid;
    }
    
    //Convertit la date actuel en string
    private static String DateToString(){
        Date date = Calendar.getInstance().getTime();
        String s = "TO_DATE('"+ (date.getYear()+1900)+ "/"+(date.getMonth()+1)+"/"+date.getDate()
                +"','YYYY/MM/DD')";
        return s;
    }
}
