/***********************************************************************
 * Module:  Jure.java
 * Author:  p1623123
 * Purpose: Defines the Class Jure
 ***********************************************************************/

package cpoa_planning;

import java.util.*;

public class Jure {
   private int ID_jure;
   private String nom_jure;
   private int nb_proj_max_j = 0;
   
   public java.util.Collection<Film> film;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Film> getFilm() {
      if (film == null)
         film = new java.util.HashSet<Film>();
      return film;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorFilm() {
      if (film == null)
         film = new java.util.HashSet<Film>();
      return film.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newFilm */
   public void setFilm(java.util.Collection<Film> newFilm) {
      removeAllFilm();
      for (java.util.Iterator iter = newFilm.iterator(); iter.hasNext();)
         addFilm((Film)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newFilm */
   public void addFilm(Film newFilm) {
      if (newFilm == null)
         return;
      if (this.film == null)
         this.film = new java.util.HashSet<Film>();
      if (!this.film.contains(newFilm))
         this.film.add(newFilm);
   }
   
   /** @pdGenerated default remove
     * @param oldFilm */
   public void removeFilm(Film oldFilm) {
      if (oldFilm == null)
         return;
      if (this.film != null)
         if (this.film.contains(oldFilm))
            this.film.remove(oldFilm);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllFilm() {
      if (film != null)
         film.clear();
   }

}