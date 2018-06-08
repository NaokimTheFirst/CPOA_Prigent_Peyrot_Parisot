/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author myria
 */
public class Bd {
public static final String passwd = "288430";
public static final String user = "p1623123"; 
    /**
     * @param args the command line arguments
     */
    public static ResultSet FaireRequete(String requete) {
        // TODO code application logic here
        try
        {
            //configuration du driver
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            //CONNECTION AU SGBD 
            //URL du serveur de BD

            String url = "jdbc:oracle:thin:@iutdoua-oracle.univ-lyon1.fr:1521:orcl"; 
            //connexion à l’URL en précisant l’utilisateur et 
            // le mot de passe d’accès à la BD

            Connection connection = DriverManager.getConnection(url,user,passwd); 
            //Création de l'objet gérant les requêtes 
            Statement statement = connection.createStatement();
            //récupération du résultat d'une requête
            ResultSet result  = statement.executeQuery(requete);
            
            return result;
            
            //tant qu'il y a une ligne résultat
            /*while(result.next())
            {
                System.out.println(result.getInt(1));
                System.out.println(result.getString("nomplongeur"));
                System.out.println(result.getString("prenomplongeur"));
                
            }
            //fermeture de la connexion à la BD
            statement.close();
            connection.close();*/
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    
}
