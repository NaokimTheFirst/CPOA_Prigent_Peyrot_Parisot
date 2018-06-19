package Beans;

public class Client {
    /* Propriétés du bean */
    private String nom;
    private String prenom;
    private String fonction;
   
    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setFonction( String fonction ) {
        this.prenom = prenom;
    }

    public String getFonction() {
        return prenom;
    }

    
}