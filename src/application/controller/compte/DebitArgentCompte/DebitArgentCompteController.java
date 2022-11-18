package application.controller.compte.DebitArgentCompte;

import application.controller.Controller;
import application.model.Client.Client;
import application.model.Commande;

public class DebitArgentCompteController extends Controller {

    Commande commande;
    Client client;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {}

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
        String[] messages = {"commande"};
        notifyObservers(messages);
    }

    public float getSommeAdebiter(){
       return commande.getPanier().valeurPanier();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        String[] messages = {"client"};
        notifyObservers(messages);
    }
}
