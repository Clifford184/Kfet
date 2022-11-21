package application;

import application.model.Systeme;
import application.view.View;
import application.view.priseCommande.PriseCommandeView;

public class Main {
    public static void main(String[] args) {

        Systeme.loadAll();

        View view;
        view = new PriseCommandeView();
        view.show();

    }
}


