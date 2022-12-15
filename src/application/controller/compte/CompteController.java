package application.controller.compte;

import application.controller.Controller;
import application.model.Commande;
import application.model.Panier;
import application.model.client.Client;

public class CompteController extends Controller {

    Panier panier;
    boolean achatContexte;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        String[] messages = {"menu", "client"};
        notifyObservers(messages);
    }

    public void supprimerClient(Client pClient){
        pClient.getPromo().removeClient(pClient);
        Client.getClientListe().remove(pClient);

        String[] messages = {"client"};
        notifyObservers(messages);
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public boolean isAchatContexte() {
        return achatContexte;
    }

    public void setAchatContexte(boolean achatContexte) {
        this.achatContexte = achatContexte;
    }
}
