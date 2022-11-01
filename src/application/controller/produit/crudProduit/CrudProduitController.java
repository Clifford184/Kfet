package application.controller.produit.crudProduit;

import application.Model.Soldable.Categorie;
import application.Model.Soldable.Type;
import application.controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class CrudProduitController extends Controller {

    ArrayList<Categorie> listeCategorie = new ArrayList<Categorie>();
    ArrayList<Type> listeType = new ArrayList<Type>();

    @Override
    public void initialize() {
        try {
            Categorie platChaud = new Categorie("plat chaud");
            Categorie snackcat = new Categorie("snack");
            Categorie boissoncat = new Categorie("boisson");
            Type pizza = new Type("pizza", platChaud);
            Type snack = new Type("snack", snackcat);
            Type boisson = new Type("boisson", boissoncat);

            listeCategorie.add(platChaud);
            listeCategorie.add(snackcat);
            listeCategorie.add(boissoncat);

            listeType.add(pizza);
            listeType.add(snack);
            listeType.add(boisson);

            String[] messages = {"categorie","type"};
            notifyObservers(messages);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



    public ArrayList<Categorie> getListeCategorie() {
        return listeCategorie;
    }

    public ArrayList<Type> getListeType() {
        return listeType;
    }
}
