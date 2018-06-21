
package BD;

import java.sql.ResultSet;
import Beans.Article;

public class DAOArticle {
    //Fonction qui vérifie si le client n'existe pas déjà
    public static Article GetArticle(int id){
        Article article =  new Article();
        String requete = "Select * FROM JEEARTICLE WHERE IDARTICLE = '"+id+"'";
        ResultSet result = BD.FaireRequete(requete);
        try{
            //On crée un objet Article à partir de la BD
            result.next();
            article.setIdarticle(id);
            article.setNom(result.getString("NOM"));
            article.setMontant(result.getFloat("MONTANT"));
            article.setDescription(result.getString("DESCRIPTION"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //On ferme la connexion
        BD.CloseConnection();

        return article;
    }
}
