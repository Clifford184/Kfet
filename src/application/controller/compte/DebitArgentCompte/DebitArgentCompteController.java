package application.controller.compte.DebitArgentCompte;

import application.controller.Controller;
import application.model.Panier;
import application.model.Stock;
import application.model.client.Client;
import application.model.Commande;
import application.model.vendable.Produit;
import application.model.vendable.Vendable;

public class DebitArgentCompteController extends Controller {

    Panier panier;
    Client client;

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {}

    public void debiterClient(float pSomme){
        client.retirerArgent(pSomme);
        Commande.creerCommande(panier,client);
        //Le stock est deja a jour. Il l'est mis automatiquement lors de la prise de la commande
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier pPanier) {
        panier = pPanier;
        String[] messages = {"commande"};
        notifyObservers(messages);
    }

    public float getSommeAdebiter(){
       return panier.valeurPanier();
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
