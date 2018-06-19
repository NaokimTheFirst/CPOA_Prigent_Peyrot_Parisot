package Beans;

import java.util.ArrayList;
public class Commande {
    /* Propriétés du bean */
    private Client client;
    private int idCommande;
    private ArrayList<Article> article = new ArrayList<Article>();
    private String date;
    private String dateLivraison;
    private Float montant;
    private String statutLivraison;

    public String getDateLivraison() {
        return dateLivraison;
    }

    private void setDateLivraison() {
        int jour = Integer.parseInt(this.date.substring(8));
        int mois = Integer.parseInt(this.date.substring(5,7));
        int annee = Integer.parseInt(this.date.substring(0,4));
        jour += 3;
        if(jour > 30){
            jour = 1;
            mois += 1;
            if(mois > 12){
                mois = 1;
                annee += 1;
            }
        }
        
        String newDate = annee+"-"+mois+"-"+jour;
        this.dateLivraison = newDate;
    }

    
    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
   
    public Client getClient() {
        return client;
    }

    public void setClient( Client client ) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
       setDateLivraison();
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant() {
        montant = 0f;
        for(Article a: article){
            montant += a.getMontantTotal();
        }
    }
    
    //SetMontant pour le DAO
    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getStatutLivraison() {
        return statutLivraison;
    }

    public void setStatutLivraison( String statutLivraison ) {
        this.statutLivraison = statutLivraison;
    }

    public ArrayList<Article> getArticle() {
        return article;
    }

    public void addArticle(Article article) {
        this.article.add(article);
    }
}