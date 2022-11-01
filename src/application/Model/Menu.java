package application.Model;

import application.Model.Soldable.Soldable;

import java.util.ArrayList;

/**
 * Je ne sais pas ca sera utile, puisqu'on affichera une liste des types
 */
public class Menu{

    ArrayList<Soldable> soldableList;

    Menu singleton;

    private Menu(ArrayList<Soldable> pSoldablesList){
        soldableList = pSoldablesList;
    }

    public ArrayList<Soldable> getSoldableList() {
        return soldableList;
    }

    public Menu getInstance(){
        return singleton;
    }


}
