package application.controller.gestionSoldable.produit;

import application.Model.Soldable.Categorie;
import application.Model.Soldable.Type;
import application.controller.Controller;

import java.util.ArrayList;

public class CrudProduitController extends Controller {

    ArrayList<Type> listeType = new ArrayList<Type>();

    /**
     * methode d'initialisation du controller
     */
    @Override
    public void initialize() {
        try {
            Categorie platChaud = new Categorie("plat chaud",null);
            Categorie snackcat = new Categorie("snack",null);
            Categorie boissoncat = new Categorie("boisson",null);
            Type pizza = new Type("pizza", platChaud);
            Type snack = new Type("snack", snackcat);
            Type boisson = new Type("boisson", boissoncat);

            listeType.add(pizza);
            listeType.add(snack);
            listeType.add(boisson);

            String[] messages = {"type"};
            notifyObservers(messages);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Type> getListeType() {
        return listeType;
    }
}
