package application;

import application.view.View;
import application.view.priseCommande.PriseCommandeView;

public class Main {
    public static void main(String[] args) {

        View view;
        view = new PriseCommandeView();
        view.show();
    }
}


