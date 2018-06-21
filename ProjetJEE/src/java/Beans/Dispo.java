package Beans;

public class Dispo {
    private String nomH;
    private int jour;
    private int chambres;

    public Dispo(String nomH, int jour, int chambres) {
        this.nomH = nomH;
        this.jour = jour;
        this.chambres = chambres;
    }

    public String getNomH() {
        return nomH;
    }

    public void setNomH(String nomH) {
        this.nomH = nomH;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getChambres() {
        return chambres;
    }

    public void setChambres(int chambres) {
        this.chambres = chambres;
    }
    
    
}
