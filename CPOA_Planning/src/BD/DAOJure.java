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
    private static ArrayList<Jure> ListJure;

    public static ArrayList<Jure> GetListJure() {
        if(ListJure == null){
            FindAllJury();
        }
        return ListJure;
    }

    private static void SetListJure(ArrayList<Jure> LJ) {
        DAOJure.ListJure = LJ;
    }
    
    
    //Fonction qui récupère tous les jurés dans la BD
    private static void FindAllJury(){
        ArrayList<TypeFilm> ListCategorie = DAOTypeFilm.GetListType();
        for(TypeFilm TF: ListCategorie){
            GetJureOfCategory(TF);
            }
        }  
    
    //Fonction qui récupère toutes les catégories
    private static void GetJureOfCategory(TypeFilm TF){
        ArrayList<Jure> NewList = new ArrayList<Jure>();
        String requete = "Select * from JURE where IDCATEGORIE ="+TF.getID_type();
        boolean p;

        ResultSet result = BD_Co.FaireRequete(requete);
       
        try{
            if(result !=null){
                while(result.next())
                {
                    p = (result.getInt("PRESIDENT") == 0) ? false : true;       //Convertit le Int de la BD en bool
                    
                    Jure new_j = new Jure(result.getInt("IDCATEGORIE"),
                            result.getString("NOMJURE"),p,result.getInt("IDCATEGORIE"));
                    NewList.add(new_j);
                }
                TF.setJury(NewList);
            } else {
                return;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }          

        if(ListJure != null){
            ListJure.addAll(ListJure);
        } else {
            SetListJure (ListJure);
        }
    }
}
