/***********************************************************************
 * Module:  Salle.java
 * Author:  p1623123
 * Purpose: Defines the Class Salle
 ***********************************************************************/

package cpoa_planning;

import java.util.*;

public class Salle {
   private int ID_salle;
   private int places;
   
   public java.util.Collection<Projection> projection;
   public java.util.Collection<TypeFilm> type_Film;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Projection> getProjection() {
      if (projection == null)
         projection = new java.util.HashSet<Projection>();
      return projection;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProjection() {
      if (projection == null)
         projection = new java.util.HashSet<Projection>();
      return projection.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProjection */
   public void setProjection(java.util.Collection<Projection> newProjection) {
      removeAllProjection();
      for (java.util.Iterator iter = newProjection.iterator(); iter.hasNext();)
         addProjection((Projection)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProjection */
   public void addProjection(Projection newProjection) {
      if (newProjection == null)
         return;
      if (this.projection == null)
         this.projection = new java.util.HashSet<Projection>();
      if (!this.projection.contains(newProjection))
         this.projection.add(newProjection);
   }
   
   /** @pdGenerated default remove
     * @param oldProjection */
   public void removeProjection(Projection oldProjection) {
      if (oldProjection == null)
         return;
      if (this.projection != null)
         if (this.projection.contains(oldProjection))
            this.projection.remove(oldProjection);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProjection() {
      if (projection != null)
         projection.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TypeFilm> getType_Film() {
      if (type_Film == null)
         type_Film = new java.util.HashSet<TypeFilm>();
      return type_Film;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorType_Film() {
      if (type_Film == null)
         type_Film = new java.util.HashSet<TypeFilm>();
      return type_Film.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newType_Film */
   public void setType_Film(java.util.Collection<TypeFilm> newType_Film) {
      removeAllType_Film();
      for (java.util.Iterator iter = newType_Film.iterator(); iter.hasNext();)
         addType_Film((TypeFilm)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newType_Film */
   public void addType_Film(TypeFilm newType_Film) {
      if (newType_Film == null)
         return;
      if (this.type_Film == null)
         this.type_Film = new java.util.HashSet<TypeFilm>();
      if (!this.type_Film.contains(newType_Film))
         this.type_Film.add(newType_Film);
   }
   
   /** @pdGenerated default remove
     * @param oldType_Film */
   public void removeType_Film(TypeFilm oldType_Film) {
      if (oldType_Film == null)
         return;
      if (this.type_Film != null)
         if (this.type_Film.contains(oldType_Film))
            this.type_Film.remove(oldType_Film);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllType_Film() {
      if (type_Film != null)
         type_Film.clear();
   }

}