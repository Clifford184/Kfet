package application.Model.Soldable;

import java.util.ArrayList;

/**
 * Regroupe diffents produits qui ont un attribut commun
 * Par exemple le Type Pizza peut regrouper Pizza royale, Pizza 4 fromage, ...
 * Le Type Snack peut regrouper Snickers, Mars, Kinder Bueno, ...
 */
public class Type {

    String nom;
    Categorie categorie;
    ArrayList<Produit> produitListe = new ArrayList<>();

    public static ArrayList<Type> typeListe = new ArrayList<>();

    /**
     * Cree un nouveau type
     * @param pNom son nom
     * @param pCategorie sa categorie associee
     */
    public Type(String pNom, Categorie pCategorie){
        nom = pNom;
        categorie = pCategorie;
        typeListe.add(this);
    }

    public ArrayList<Produit> getProduitListe() {
        return produitListe;
    }

    public void setName(String pNewName){
        nom = pNewName;
    }

    public String getName() {
        return nom;
    }

    public static void deleteType(Type pType){
        typeListe.remove(pType);
    }

}
