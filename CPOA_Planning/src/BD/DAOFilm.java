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

//Fonction qui récupère tous les films par catégorie
public class DAOFilm {
    private static ArrayList<Film> listFilm;

    public static ArrayList<Film> GetListFilm() {
        if(listFilm == null){
            GetAllFilms();
        }
        return listFilm;
    }

    //
    private static void SetListFilm(ArrayList<Film> LF) {
        listFilm = LF;
    } 
    
    //
    private static void GetAllFilms(){
        ArrayList<TypeFilm> ListCategorie = DAOTypeFilm.GetListType();
        for(TypeFilm f: ListCategorie){
            SetFilmsOfCategory(f);
            }
        }            
    //Fonction qui ajoute tous les films a une catégorie
    private static void SetFilmsOfCategory(TypeFilm TF){
        ArrayList<Film> ListFilm = new ArrayList<Film >();
        String requete = "Select * from FILM where IDCATEGORIE = "+TF.getID_type();

        ResultSet result = BD_Co.FaireRequete(requete);
       
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
                return;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }            
        
        if(listFilm != null){
            listFilm.addAll(ListFilm);
        } else {
            SetListFilm(listFilm);
        }
    }
}
