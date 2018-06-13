/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import cpoa_planning.TypeFilm;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DAOTypeFilm {
    private static ArrayList<TypeFilm> ListFilm;

    public static ArrayList<TypeFilm> GetListType() {
        if(ListFilm == null){
            FindAllCompetitions();
        }
        return ListFilm;
    }

    private static void SetListFilm(ArrayList<TypeFilm> LF) {
        ListFilm = LF;
    }
    
    //Fonction qui récupère toutes les catégories
    private static void FindAllCompetitions(){
        ArrayList<TypeFilm> NewList = new ArrayList<TypeFilm>();
        String requete = "Select * from CATEGORIE";

        ResultSet result = BD_Co.FaireRequete(requete);
       
        try{
            if(result !=null){
                while(result.next())
                {
                    TypeFilm new_t;
                    new_t = new TypeFilm(result.getInt("IDCATEGORIE"),result.getString("NOM"));
                    NewList.add((new_t));
                }
            } else {
                return;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        SetListFilm(NewList);
    }
}
