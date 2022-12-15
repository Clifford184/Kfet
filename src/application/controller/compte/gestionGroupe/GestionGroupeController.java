package application.controller.compte.gestionGroupe;

import application.controller.Controller;
import application.model.client.Groupe;

public class GestionGroupeController extends Controller {
    @Override
    public void initialize() {
        String[] messages = {"initialiseView", "menu", "groupe"};
        notifyObservers(messages);
    }


    public boolean supprimerGroupe(Groupe pGroupe){
        if (pGroupe.getClientListe().size() == 0){
            Groupe.getGroupeListe().remove(pGroupe);

            String[] messages = {"groupe"};
            notifyObservers(messages);
            return true;
        }
        else {
           return false;
        }
    }
}
