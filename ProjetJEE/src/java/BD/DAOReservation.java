/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import BD.*;
import Beans.*;
import java.sql.ResultSet;

/**
 *
 * @author Moi
 */
public class DAOReservation {
    public static void AddResa(String NomH,int Jour, String NomV){
        String requete = "INSERT INTO RESERVATION (NOMH,JOUR,NOMVIP) VALUES ('"+NomH+"','"+ Jour+"','"+NomV+"')";
        BD.FaireRequete(requete);
        BD.CloseConnection();
    }
}
