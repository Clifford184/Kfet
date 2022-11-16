package application.controller.methodePayement;

import application.controller.Controller;
import application.model.Commande;

public class MethodePayementController extends Controller {

    private Commande commande;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {}


    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
