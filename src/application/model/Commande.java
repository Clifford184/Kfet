package application.model;

import application.model.client.Client;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Decrit une commande qui a ete passee sur l'application
 */
public class Commande implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    UUID id;
    LocalDateTime date;
    Client client;
    Panier panier;

    State etatActuel;

    public enum State{
        COMMENCEE,
        PAYEE,
        EN_COURS,
        TERMINEE
    }

    static ArrayList<Commande> commandeListe = new ArrayList<>();

    /**
     * Cree une nouvelle commande
     * @param pPanier l'objet panier de la commande
     */
    public Commande(Panier pPanier){
        panier = pPanier;
        date = LocalDateTime.now();
        etatActuel = State.COMMENCEE;
    }

    /**
     * Appele avant la creation de l'objet lors de la deserialization
     * Verifie que l'objet n'a pas deja ete cree
     * @return le nouvel objet cree ou sa reference dans la liste statique
     */
    @Serial
    private Object readResolve() {

        for(Commande p : commandeListe){
            if(p.id.equals(this.id))
                return p;
        }
        commandeListe.add(this);
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Panier getCart() {
        return panier;
    }

    public void setCart(Panier panier) {
        this.panier = panier;
    }

    public State getEtatActuel() {
        return etatActuel;
    }

    public void setEtatActuel(State etatActuel) {
        this.etatActuel = etatActuel;
    }
}
