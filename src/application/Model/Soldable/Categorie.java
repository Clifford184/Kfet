package application.Model.Soldable;

import java.awt.*;
import java.util.ArrayList;


public class Categorie {

    String name;
    Image image;

    public static ArrayList<Categorie> categorieArrayList = new ArrayList<>();

    public Categorie(String pName){
        name = pName;
    }

    @Override
    public String toString() {
        return name;
    }
}
