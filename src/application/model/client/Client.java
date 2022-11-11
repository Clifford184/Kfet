package application.model.client;

import java.io.Serializable;

/**
 * Decrit un client possedant un compte dans l'application
 */
public class Client implements Serializable {

    String nom;
    String prenom;
    Groupe groupe;
    float argent;

    /**
     * Cree un nouveau client
     * @param pNom son nom
     * @param pPrenom son prenom
     * @param pGroupe son groupe
     */
    public Client(String pNom, String pPrenom, Groupe pGroupe){
        nom = pNom;
        prenom = pPrenom;
        groupe = pGroupe;
        groupe.ajouterClient(this);
    }

    public void ajouterArgent(float pMoney){
        argent += pMoney;
    }

    public void retirerArgent(float pAmount){
        argent -= pAmount;
    }

    public void promoUp(){
        groupe = groupe.groupeSuivant;
    }

    public void promoDown(){
        groupe = groupe.groupePrecedent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Groupe getPromo() {
        return groupe;
    }

    public void setPromo(Groupe groupe) {
        this.groupe = groupe;
    }

    public float getArgent() {
        return argent;
    }

    public void setArgent(float argent) {
        this.argent = argent;
    }
}
