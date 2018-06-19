package cpoa_planning;

import java.util.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Projection {
   private static int lastIndex = -1;
   private int ID_proj;
   private LocalDateTime hdeb;
   private LocalDateTime hfin;
   private boolean competition;
   private Salle salle;
   private Film film;

    public Projection(LocalDateTime hdeb, boolean competition, Film f, Salle s) {
        ID_proj = lastIndex+1;
        lastIndex = ID_proj;
        this.hdeb = hdeb;
        this.hfin = FindEndHours(hdeb,f) ;
        this.competition = competition;
        this.salle = s;
        this.film = f;
    }
    
    //Fonction qui détermine l'heure de la fin de séance en ajoutant la durée à l'heure du début
    private LocalDateTime FindEndHours(LocalDateTime d, Film f){
        int duree = f.getDuree();
        int heure = d.getHour() + duree/60;
        int minutes = d.getMinute() + duree%60;
        int jour = d.getDayOfMonth();
        int mois = d.getMonthValue();
        
        if(minutes >= 60){
            heure += 1;
            minutes = minutes%60;
        }
        
        if(heure >= 24){
                heure = heure - 24;
                jour++;
                if(jour>30){
                    mois++;
                    jour = 1;
                }
            }
        
        LocalDateTime newDate = LocalDate.of(d.getYear(),mois,jour).atTime(heure,minutes);
        return newDate;
    }

    public int getID_proj() {
        return ID_proj;
    }

    public LocalDateTime getHdeb() {
        return hdeb;
    }

    public LocalDateTime getHfin() {
        return hfin;
    }

    public boolean isCompetition() {
        return competition;
    }

    public Salle getSalle() {
        return salle;
    }

    public Film getFilm() {
        return film;
    }
    
    
}