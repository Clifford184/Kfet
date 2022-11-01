package application.controller;

import application.Model.Cart;
import application.Model.Order;
import application.Model.Soldable.Offer;
import application.Model.Soldable.Product;
import application.Model.Soldable.Type;

public class TakeOrderController {

    Cart cart;
    Order order;

    public void startOrder(){
        cart = new Cart();
        order = new Order(cart);
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

    public void addOffer(Offer pOffer){
        //Changement d'interface
        //l'interface pour les offer sera geree dynamiquement puisque seront creer par les administrateurs
    }

    public void confirmCart(){
        //Changement d'écran
        //Appeler changement d'interface
        //Choix mode paiement
    }

}
