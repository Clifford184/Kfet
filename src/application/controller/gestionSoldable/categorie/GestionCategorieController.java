package application.controller.gestionSoldable.categorie;

import application.controller.Controller;

public class GestionCategorieController extends Controller {

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"categorie"};
        notifyObservers(messages);
    }
}
