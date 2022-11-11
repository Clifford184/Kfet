package application.Model;

import application.Model.Client.Client;
import java.time.LocalDateTime;

/**
 * Decrit une commande qui a ete passee sur l'application
 */
public class Commande {

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

    /**
     * Cree une nouvelle commande
     * @param pPanier l'objet panier de la commande
     */
    public Commande(Panier pPanier){
        panier = pPanier;
        date = LocalDateTime.now();
        etatActuel = State.COMMENCEE;
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
