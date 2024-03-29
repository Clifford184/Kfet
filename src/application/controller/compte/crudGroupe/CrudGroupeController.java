package application.controller.compte.crudGroupe;

import application.controller.Controller;
import application.model.Panier;
import application.model.client.Client;
import application.model.client.Groupe;

public class CrudGroupeController extends Controller {

    Groupe groupe;

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

    public void modifierGroupe(String pNom){
        this.groupe.setNom(pNom);
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;

        String[] messages = {"groupe"};
        notifyObservers(messages);
    }
}

