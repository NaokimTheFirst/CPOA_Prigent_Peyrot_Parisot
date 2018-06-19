package BD;

import java.sql.*;

public class BD_Co {
private final static String passwd = "288430";
private final static  String user = "p1623123"; 
private static Connection connection;

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
            if(connection == null){
                connection = DriverManager.getConnection(url,user,passwd); 
            }
            //Création de l'objet gérant les requêtes 
            Statement statement = connection.createStatement();
            //récupération du résultat d'une requête
            ResultSet result  = statement.executeQuery(requete);
            
            return result;
            
            //fermeture de la connexion à la BD
            /*statement.close();
            connection.close();*/
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
    
}
