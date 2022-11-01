package Model.Soldable;

import java.util.ArrayList;

/**
 * Group differents products with common attributes (for example the type Pizza for all the pizza sellable)
 */
public class Type {

    String name;
    Categorie categorie;

    public static ArrayList<Type> typeList = new ArrayList<>();

    /**
     * Creates a new type
     * @param pName
     * @param pCategorie
     */
    public Type(String pName, Categorie pCategorie){
        name = pName;
        categorie = pCategorie;
        typeList.add(this);
    }

    public void setName(String pNewName){
        name = pNewName;
    }

    public String getName() {
        return name;
    }

    public static void deleteType(Type pType){
        typeList.remove(pType);
    }

}
