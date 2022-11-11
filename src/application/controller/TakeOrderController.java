package application.controller;

import application.model.Panier;
import application.model.Commande;
import application.model.vendable.Offre;
import application.model.vendable.Type;

public class TakeOrderController {

    Panier panier;
    Commande commande;

    public void startOrder(){
        panier = new Panier();
        commande = new Commande(panier);
    }

    public void getTypeToShow(){
        //On return je ne sais pas quoi,

    }

    public void selectType(Type pType){

        //Changement d'interface vers le choix du produit en particulier
    }
// TODO methode inexistante ???
//    public void addProduct(Product pProduct){
//        cart.getProductList().add(pProduct);
//    }

    public void addOffer(Offre pOffre){
        //Changement d'interface
        //l'interface pour les offer sera geree dynamiquement puisque seront creer par les administrateurs
    }

    public void confirmCart(){
        //Changement d'écran
        //Appeler changement d'interface
        //Choix mode paiement
    }

}
