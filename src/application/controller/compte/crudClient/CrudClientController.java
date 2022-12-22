package application.controller.compte.crudClient;

import application.controller.Controller;
import application.model.client.Client;
import application.model.client.Groupe;

public class CrudClientController extends Controller {

    Client client;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"initialiseView", "promo"};
        notifyObservers(messages);
    }

    public void creerClient(String pNom, String pPrenom, Groupe pGroupe){
        new Client(pNom, pPrenom, pGroupe);
    }

    public void modifierClient(String pNom, String pPrenom, Groupe pGroupe){
        client.setNom(pNom);
        client.setPrenom(pPrenom);
        client.getPromo().removeClient(client);
        client.setPromo(pGroupe);
        client.getPromo().ajouterClient(client);
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
