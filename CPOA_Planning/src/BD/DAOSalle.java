/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import cpoa_planning.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author p1623123
 */
public class DAOSalle {
private static ArrayList<Salle> ListSalle;

    public static ArrayList<Salle> GetListSalle() {
        if(ListSalle == null){                                                  //Si la liste n'existe pas, on la crée
            FindAllSalles();
        }
        return ListSalle;
    }

    private static void SetListSalle(ArrayList<Salle> LS) {
        DAOSalle.ListSalle = LS;
    }
    

    //Fonction qui récupère toutes les salles depuis la BD
    private static void FindAllSalles(){
        ArrayList<Salle> NewList = new ArrayList<Salle>();
        String requete = "Select * from SALLE";

        ResultSet result = BD_Co.FaireRequete(requete);
       
        try{
            if(result !=null){
                while(result.next())
                {
                    Salle new_s;
                    new_s = new Salle(result.getInt("IDSALLE"),result.getString("NOM"),
                            result.getInt("PLACES"));
                    NewList.add(new_s);
                }
                
            } else {
                return;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        
        for(Salle s: NewList){                                                  //Attribue les salles aux catégories correspondantes
            SetSallesForCategories(s);
        }
        SetListSalle(NewList);
    }
    
    //Fonction qui définit les salles pour chaque catégorie
    private static void SetSallesForCategories(Salle s){
        ArrayList<TypeFilm> ListTypes = DAOTypeFilm.GetListType();              //Récupère la liste de tous les types
        
        String requete = "Select IDCATEGORIE from SALCAT where IDSALLE ="+ s.getID_salle();
        ResultSet result = BD_Co.FaireRequete(requete);
    
        try{
            if(result !=null){
                while(result.next())
                {
                    int i = result.getInt("IDCATEGORIE");
                    for(TypeFilm TF: ListTypes){                                //Pour chaque catégorie
                        if(TF.getID_type() == i){                               //Si l'ID correspond
                            TF.AddSalle(s);                                     //Ajoute la salle
                        }
                    }
                }
            } else {
                    return;
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
              
        return;
    }
}
