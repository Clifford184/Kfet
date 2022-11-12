package application.controller.priseCommande;

import application.model.vendable.Categorie;
import application.model.vendable.Type;
import application.controller.Controller;

public class PriseCommandeController extends Controller {

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize()  {
        String[] messages = {"type"};
        notifyObservers(messages);
    }
}
