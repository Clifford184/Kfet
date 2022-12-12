package application.controller.compte.crudClient;

import application.controller.Controller;
import application.model.client.Client;
import application.model.client.Groupe;

public class CrudClientController extends Controller {

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
}
