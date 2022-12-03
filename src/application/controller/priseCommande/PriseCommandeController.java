package application.controller.priseCommande;

import application.model.Panier;
import application.model.Stock;
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
        String[] messages = {"menu","type"};
        notifyObservers(messages);
    }

    public ArrayList<Produit> getProduitType(Type pType){
        return pType.getProduitListe();
    }

    public void ajouterAuPanier(Produit pProduit){
        panier.ajouterElement(pProduit);
        Stock.getInstance().retirerDuStock(pProduit,1);

        String[] messages = {"panier"};
        notifyObservers(messages);
    }

    public void viderPanier(){
        Stock stock = Stock.getInstance();
        for(Vendable v : panier.getSoldableList()){
            if(v instanceof Offre){
                for(Produit p : ((Offre)v).getProduitListe()){
                    stock.remplirStock(p,1);
                }
            }else{
                stock.remplirStock((Produit)v,1);
            }
        }
    }

    public Panier getPanier() {
        return panier;
    }
}
