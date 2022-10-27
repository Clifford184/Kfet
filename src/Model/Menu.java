package Model;

import Model.Soldable.Soldable;

import java.util.ArrayList;

/**
 * Fais office de carte en Francais
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
