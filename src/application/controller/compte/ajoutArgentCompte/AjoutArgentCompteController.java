package application.controller.compte.ajoutArgentCompte;

import application.controller.Controller;
import application.model.Commande;
import application.model.Stock;
import application.model.client.Client;
import application.model.vendable.Produit;
import application.model.vendable.Vendable;

public class AjoutArgentCompteController extends Controller {

    Client client;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"initialiseView"};
        notifyObservers(messages);
    }

    public void ajouterAgentClient(float pArgent){
        client.setArgent(client.getArgent()+pArgent);
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
