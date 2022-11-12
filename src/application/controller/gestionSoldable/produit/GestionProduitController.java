package application.controller.gestionSoldable.produit;

import application.controller.Controller;

public class GestionProduitController extends Controller {

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"produit"};
        notifyObservers(messages);
    }
}
