/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import cpoa_planning.Film;
import cpoa_planning.TypeFilm;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author p1623123
 */
public class DAOFilm {
    public static void Get_All_Films(ArrayList<TypeFilm> ListCategorie){
        ArrayList<Film> ListFilm = new ArrayList<Film >();
        for(TypeFilm f: ListCategorie){
            Get_Films_Of_Category(f);
            }
        }            
    
    private static ArrayList<Film> Get_Films_Of_Category(TypeFilm TF){
        ArrayList<Film> ListFilm = new ArrayList<Film >();
        String requete = "Select * from FILM where IDCATEGORIE = "+TF.getID_type();

        ResultSet result = bd.Bd.FaireRequete(requete);
       
        try{
            if(result !=null){
                while(result.next())
                {
                    Film newF;
                    newF = new Film(result.getInt("IDFILM"),result.getString("TITRE"),
                            result.getString("GENRE"),result.getString("REAL"),result.getInt("DUREE"),result.getInt("IDCATEGORIE"));
                    ListFilm.add(newF);
                }
                TF.SetListFilm(ListFilm);
            } else {
                System.out.println("requête échoué");
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }            
        return ListFilm;
    }
}
