package BD;

import java.sql.*;



public class BD {
   
public static final String passwd = "288430";
public static final String user = "p1623123";
private static Connection connection;

    public static ResultSet FaireRequete(String requete) {
        try
        {
            //configuration du driver
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            //CONNECTION AU SGBD 
            //URL du serveur de BD

            String url = "jdbc:oracle:thin:@iutdoua-oracle.univ-lyon1.fr:1521:orcl"; 
            //connexion à l’URL en précisant l’utilisateur et 
            // le mot de passe d’accès à la BD
            
            connection = DriverManager.getConnection(url,user,passwd); 
            //Création de l'objet gérant les requêtes 
            Statement statement = connection.createStatement();
            //récupération du résultat d'une requête
            ResultSet result  = statement.executeQuery(requete);
            return result;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static void CloseConnection(){
        try {
            connection.close();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
