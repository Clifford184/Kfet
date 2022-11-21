package application.controller.priseCommande;

import application.model.Panier;
import application.model.vendable.*;
import application.controller.Controller;

import java.util.ArrayList;

public class PriseCommandeController extends Controller {

    Panier panier = new Panier();

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize()  {
        String[] messages = {"type"};
        notifyObservers(messages);
    }

    public ArrayList<Produit> getProduitType(Type pType){
        int indexType = Type.getTypeListe().indexOf(pType);
        return Type.getTypeListe().get(indexType).getProduitListe();
    }

    public void ajouterAuPanier(Produit pProduit){
        panier.ajouterElement(pProduit);

        String[] messages = {"panier"};
        notifyObservers(messages);
    }

    public Panier getPanier() {
        return panier;
    }
}
