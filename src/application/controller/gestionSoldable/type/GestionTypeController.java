package application.controller.gestionSoldable.type;

import application.controller.Controller;

public class GestionTypeController extends Controller {

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"menu", "type"};
        notifyObservers(messages);
    }
}
