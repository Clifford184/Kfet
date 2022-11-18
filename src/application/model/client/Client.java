package application.model.client;

import application.model.vendable.Type;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Decrit un client possedant un compte dans l'application
 */
public class Client implements Serializable {

    UUID id;
    String nom;
    String prenom;
    Groupe groupe;
    float argent;

    static ArrayList<Client> clientListe = new ArrayList<>();

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
        clientListe.add(this);
    }

    /**
     * Appele avant la creation de l'objet lors de la deserialization
     * Verifie que l'objet n'a pas deja ete cree
     * @return le nouvel objet cree ou sa reference dans la liste statique
     */
    @Serial
    private Object readResolve() {

        for(Client p : clientListe){
            if(p.id.equals(this.id))
                return p;
        }
        clientListe.add(this);
        return this;
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
