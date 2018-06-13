package BD;
import cpoa_planning.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class DAOProjection {
    
    //Ajoute un objet Projection existant à la BD
    public static boolean AddProjToBD(Projection p){
        String dateDeb = DateToString(p.getHdeb());
        String dateFin = DateToString(p.getHfin());
        
        String requete = "INSERT INTO PROJECTION VALUES ("+p.getID_proj()
                +", TO_DATE("+ dateDeb+"),TO_DATE("+ dateFin +"),"
                +p.getFilm().getID_film()+","+p.getSalle().getID_salle()+")";
        BD_Co.FaireRequete(requete);
       
        return false;
    }
    
    //Supprime toutes les lignes de la table Projection
    public static void DropProjectionTable(){
        String requete ="DELETE FROM PROJECTION";
        BD_Co.FaireRequete(requete);
    }
    
    //Convertie le type LocalDateTime en string pour la requete
    private static String DateToString(LocalDateTime d){
        String s = "'"+d.getYear() + "/"+d.getMonthValue()+"/"+d.getDayOfMonth()
                +" "+d.getHour()+":"+d.getMinute()+"','YYYY/MM/DD HH24:MI'";
        return s;
    }
}
