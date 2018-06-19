package Beans;

import java.util.ArrayList;
public class Hebergement {
    /* Propriétés du bean */
    private Client client;
    private int numhebergement;
    private String nomhebergement;
    private String type;
    private String adresse;
    private String services;
    private String cible;

    public String getCible() {
        return cible;
    }

    public void setCible(String cible) {
        this.cible = cible;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getNumhebergement() {
        return numhebergement;
    }

    public void setNumhebergement(int numhebergement) {
        this.numhebergement = numhebergement;
    }

    public String getNomhebergement() {
        return nomhebergement;
    }

    public void setNomhebergement(String nomhebergement) {
        this.nomhebergement = nomhebergement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }
}