package org.isa.gui;

public class Client {
    private  String nom;
    private  String prenom;
    private  String ville;

    /**
     *Constructeur par défaut
     */
    public Client() {}

    /**
     * Constructeur avec paramètres
     * @param nom : nom du client
     * @param prenom :prénom du client
     * @param ville :ville du client
     */
    public Client(String p, String n, String v) {
        this.prenom = p;
        this.nom = n;
        this.ville = v;
    }
    //Getters and Setters
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}