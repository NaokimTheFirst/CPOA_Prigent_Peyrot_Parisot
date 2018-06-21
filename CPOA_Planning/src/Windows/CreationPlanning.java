package Windows;

import BD.*;
import cpoa_planning.*;
import java.time.*;
import java.util.ArrayList;

public class CreationPlanning {
    
    public static void Start(){
        ArrayList<TypeFilm> ListCategorie;
        ListCategorie = DAOTypeFilm.GetListType();
        DAOFilm.GetListFilm();
        DAOJure.GetListJure();
        DAOSalle.GetListSalle();

        //DisplayFilmByCategorie(ListCategorie);

        //Projection p = Add_Projection(ListCategorie.get(0).GetSalles().get(0),ListCategorie.get(0).getFilm().get(0));       
        //DAOProjection.AddProjToBD(p);
        DAOProjection.DropProjectionTable();
        SetLongMetrage();
    }
    
    //Fonction qui définit les projections des longs métrages
    private static void SetLongMetrage(){
        LocalDateTime prochainCreneau = getDate(2018,06,20,8,30);
        TypeFilm LongMetrage = DAOTypeFilm.GetListType().get(0);                //Récupère la catégorie long métrage
        ArrayList<Film> Films = LongMetrage.getFilm();
        
        for(int i = 0; i < Films.size();i++){
<<<<<<< HEAD
=======
            //Ajoute la séance du lendemain
            Add_Projection(LongMetrage.GetSalles().get(1),Films.get(i),getNextDay(prochainCreneau));
            //Ajoute les séances dans la salle principale
>>>>>>> Benoit
            for(int j = 0; j < 2;j++){
                prochainCreneau = Add_Projection(LongMetrage.GetSalles().get(0),Films.get(i),prochainCreneau);
                prochainCreneau = getNextSession(prochainCreneau);
            }
        }
<<<<<<< HEAD
       
=======
>>>>>>> Benoit
    }
    
    
    //Fonction qui ajoute une projection
    private static LocalDateTime Add_Projection(Salle s, Film f, LocalDateTime Ddeb){
        ArrayList<TypeFilm> ListCategorie = DAOTypeFilm.GetListType();        
        
        Projection p = new Projection(Ddeb,true,f,s);
        DAOProjection.AddProjToBD(p);
        LocalDateTime heureFin = p.getHfin();
        s.Add_Projection(p);
        f.Add_Projection(p);
        
        return heureFin;
    }
    
    //Retourne une localDateTime
    private static LocalDateTime getDate(int année, int mois, int jours, int heure, int minutes){
        LocalDateTime newDate = LocalDate.of(année, mois,jours).atTime(heure,minutes);
        return newDate;
    }
    
    //Ajoute 15 min de pause entre chaque séance
    private static LocalDateTime getNextSession(LocalDateTime lastSession){
        int minute = lastSession.getMinute();
        int hour = lastSession.getHour();
        int jour = lastSession.getDayOfMonth();
        minute += 15;
        
        if(minute/60 >= 1){
            hour ++;
            minute = minute%60;
            
        }
        
        if(hour>22){
                jour++;
                hour = 8;
                minute = 30;
         }
        
        lastSession = getDate(lastSession.getYear(),lastSession.getMonthValue(),jour,hour,minute);
        return lastSession;
    }
    
<<<<<<< HEAD
=======
    //Ajoute 15 min de pause entre chaque séance
    private static LocalDateTime getNextDay(LocalDateTime lastSession){
        int jour = lastSession.getDayOfMonth();
        jour++;
        
        lastSession = getDate(lastSession.getYear(),lastSession.getMonthValue()
                ,jour,lastSession.getHour(),lastSession.getMinute());
        return lastSession;
    }
    
>>>>>>> Benoit
    //Fonction qui affiche les films par catégorie
    private void DisplayFilmByCategorie(ArrayList<TypeFilm> ListCategorie){
        String s;
        
        System.out.println("Les catégories dans la BD sont :\n");
        for(TypeFilm TF: ListCategorie){
            System.out.println(TF.getID_type()+" "+TF.getNom_type());
            System.out.println("Les films de cette catégorie sont :");
            for(Film f: TF.getFilm()){
                System.out.println("    "+f.getID_film()+" "+f.getTitre()+" réalisé par "+f.getReal());
            }
            
            System.out.println("\n Les Jurés de cette catégorie sont :");
            for(Jure j: TF.getJury()){
                s = "    "+j.getNom_jure();
                if(j.isPresident()){
                  s += "(Président)";
                }
                System.out.println(s);
            }
            System.out.println("\n Les Salles de cette catégorie sont :");
            for(Salle sal : TF.GetSalles()){
                System.out.println("    "+sal.GetName());
            }
            System.out.println("");
        }
    }
}
