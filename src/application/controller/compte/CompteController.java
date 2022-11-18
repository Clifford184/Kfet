package application.controller.compte;

import application.controller.Controller;
import application.model.Client.Client;
import application.model.Commande;

public class CompteController extends Controller {

    Commande commande;

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
