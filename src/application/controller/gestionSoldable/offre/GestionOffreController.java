package application.controller.gestionSoldable.offre;

import application.controller.Controller;

public class GestionOffreController extends Controller {

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"menu", "offre"};
        notifyObservers(messages);
    }
}
