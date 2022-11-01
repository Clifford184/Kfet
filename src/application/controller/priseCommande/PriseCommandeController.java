package application.controller.priseCommande;

import application.Model.Cart;
import application.Model.Soldable.Categorie;
import application.Model.Soldable.Product;
import application.Model.Soldable.Soldable;
import application.Model.Soldable.Type;
import application.controller.Controller;

public class PriseCommandeController extends Controller {

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize()  {
        try {
            // Création de type test pour la prise de commande
            Categorie platChaud = new Categorie("plat chaud",null);
            Type pizza = new Type("pizza", platChaud);

            String[] messages = {"type"};
            notifyObservers(messages);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
