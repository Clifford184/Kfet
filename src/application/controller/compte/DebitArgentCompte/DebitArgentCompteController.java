package application.controller.compte.DebitArgentCompte;

import application.controller.Controller;
import application.model.Stock;
import application.model.client.Client;
import application.model.Commande;
import application.model.vendable.Produit;
import application.model.vendable.Vendable;

public class DebitArgentCompteController extends Controller {

    Commande commande;
    Client client;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {}

    public void debiterClient(float pSomme){
        client.retirerArgent(pSomme);
        //TODO gerer retirer menu et produit
        for (Vendable vendable : commande.getPanier().getSoldableList()){
            if(vendable instanceof Produit) {
                Stock.getInstance().retirerDuStock((Produit) vendable, 1);
            }
        }

    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
        String[] messages = {"commande"};
        notifyObservers(messages);
    }

    public float getSommeAdebiter(){
       return commande.getPanier().valeurPanier();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        String[] messages = {"client"};
        notifyObservers(messages);
    }
}
