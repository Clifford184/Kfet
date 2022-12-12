package application.controller.methodePayement;

import application.controller.Controller;
import application.model.Commande;
import application.model.Panier;

public class MethodePayementController extends Controller {

    private Panier panier;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {}

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
}
