package application.controller.priseCommande;

import application.Model.Cart;
import application.Model.Soldable.Categorie;
import application.Model.Soldable.Product;
import application.Model.Soldable.Soldable;
import application.Model.Soldable.Type;
import application.controller.Controller;

import java.io.IOException;

public class PriseCommandeController extends Controller {

    private Cart cart = new Cart();

    @Override
    public void initialize()  {
        try {
            // Création de solvable test pour la carte
            Categorie platChaud = new Categorie("plat chaud");
            Type pizza = new Type("pizza", platChaud);
            Product pizzaChevre = new Product("pizza chèvre",2f,2.5f,pizza);
            cart.getProductList().add(pizzaChevre);

            String[] messages = {"cart"};
            notifyObservers(messages);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Cart getCart() {
        return cart;
    }
}
