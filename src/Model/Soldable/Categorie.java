package Model.Soldable;

import java.awt.*;
import java.util.ArrayList;

/**
 * Defines a set of type
 * For example the Categorie "Hot dish" could contains the Types "Pizza" and "PlatPicard"
 */
public class Categorie {

    String name;
    Image image;

    ArrayList<Type> linkedTypeList;

    public static ArrayList<Categorie> categorieArrayList = new ArrayList<>();

    /**
     * Create a new categorie
     * @param pName his name
     * @param pLinkedTypeList
     */
    public Categorie(String pName, ArrayList<Type> pLinkedTypeList){
        name = pName;
        linkedTypeList = pLinkedTypeList;
    }

}
