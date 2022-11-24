package application;

import application.model.Systeme;
import application.model.vendable.Categorie;
import application.model.vendable.Produit;
import application.model.vendable.Type;
import application.view.View;
import application.view.priseCommande.PriseCommandeView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        /*Categorie c1 = new Categorie("Plat chaud");
        Categorie c2 = new Categorie("Boisson");

        try {
            Type t = new Type("Cafe",c2,"");
            Type t2 = new Type("Boisson froide", c2, "");
            Type t3 = new Type("Pizza", c1, "");
            Type t4 = new Type("Picard",c1, "");

            new Produit("Pizza chevre", 1.8f,2.7f,2.5f,t3,"");
            new Produit("Pizza 4 fromages", 1.9f,2.7f,2.5f,t3,"");
            new Produit("Coca cola", 0.4f,0.8f,0.6f,t2,"");
            new Produit("Oasis", 0.4f,0.8f,0.6f,t2,"");
        } catch (IOException e) {
            e.printStackTrace();
        }*/



        Systeme.loadAll();

        View view;
        view = new PriseCommandeView();
        view.show();

    }
}


