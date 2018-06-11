/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import cpoa_planning.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOJure {
    
    public static void Get_All_Jury(ArrayList<TypeFilm> ListCategorie){
        for(TypeFilm TF: ListCategorie){
            Get_Jure_Of_Category(TF);
            }
        }  
    
    //Fonction qui récupère toutes les catégories
    public static ArrayList<Jure> Get_Jure_Of_Category(TypeFilm TF){
        ArrayList<Jure> ListJure = new ArrayList<Jure>();
        String requete = "Select * from JURE where IDCATEGORIE ="+TF.getID_type();
        boolean p;

        ResultSet result = bd.Bd.FaireRequete(requete);
       
        try{
            if(result !=null){
                while(result.next())
                {
                    p = (result.getInt("PRESIDENT") == 0) ? false : true;       //Convetit le Int de la BD en bool
                    
                    Jure new_j;
                    new_j = new Jure(result.getInt("IDCATEGORIE"),
                            result.getString("NOMJURE"),p);
                    ListJure.add(new_j);
                }
                TF.setJury(ListJure);
            } else {
                return null;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }            
        return ListJure;
    }
}
