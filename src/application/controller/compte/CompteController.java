package application.controller.compte;

import application.controller.Controller;
import application.model.Commande;

public class CompteController extends Controller {

    Commande commande;
    boolean achatContexte;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"menu", "client"};
        notifyObservers(messages);
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public boolean isAchatContexte() {
        return achatContexte;
    }

    public void setAchatContexte(boolean achatContexte) {
        this.achatContexte = achatContexte;
    }
}
