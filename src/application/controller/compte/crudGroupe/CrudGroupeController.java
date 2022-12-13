package application.controller.compte.crudGroupe;

import application.controller.Controller;
import application.model.Panier;
import application.model.client.Groupe;

public class CrudGroupeController extends Controller {

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"initialiseView"};
        notifyObservers(messages);
    }

    public void creerGroupe(String pNom){
        new Groupe(pNom);
    }
}

