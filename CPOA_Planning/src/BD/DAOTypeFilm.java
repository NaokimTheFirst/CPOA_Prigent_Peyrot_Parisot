/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import cpoa_planning.TypeFilm;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author p1623123
 */
public class DAOTypeFilm {
    //Fonction qui récupère toutes les catégories
    public static ArrayList<TypeFilm> Get_All_Competitions(){
        ArrayList<TypeFilm> ListCategorie = new ArrayList<TypeFilm>();
        String requete = "Select * from CATEGORIE";

        ResultSet result = bd.Bd.FaireRequete(requete);
       
        try{
            if(result !=null){
                while(result.next())
                {
                    TypeFilm new_t;
                    new_t = new TypeFilm(result.getInt("IDCATEGORIE"),result.getString("NOM"));
                    ListCategorie.add((new_t));
                }
            } else {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }            
        return ListCategorie;
    }
}
