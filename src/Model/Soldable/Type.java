package Model.Soldable;

import java.util.ArrayList;

public class Type {

    String name;
    Categorie categorie;

    public static ArrayList<Type> typeList = new ArrayList<>();

    public Type(String pName, Categorie pCategorie){
        name = pName;
        categorie = pCategorie;
        typeList.add(this);
    }

    public void setName(String pNewName){
        name = pNewName;
    }

    public static void deleteType(Type pType){
        typeList.remove(pType);
    }

    public static ArrayList<Type> getTypeByCategorie(Categorie pCategorie){
        ArrayList<Type> toReturn = new ArrayList<>();
        for(Type t : typeList){
            if(t.categorie.equals(pCategorie))
                toReturn.add(t);
        }
        return toReturn;
    }

}
