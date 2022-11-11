package application.controller.priseCommande;

import application.model.vendable.Categorie;
import application.model.vendable.Type;
import application.controller.Controller;

public class PriseCommandeController extends Controller {

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize()  {
        try {
            // Création de type test pour la prise de commande
            Categorie platChaud = new Categorie("plat chaud");
            Type pizza = new Type("pizza", platChaud,"");

            String[] messages = {"type"};
            notifyObservers(messages);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
