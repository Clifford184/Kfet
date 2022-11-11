package application.model.vendable;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Decrit une categorie de type.
 * Une categorie permet de regrouper plusieurs types selon la volonte de l'utilisateur.
 * Un type peut appartenir a plusieurs categorie.
 * Les categories sont utilisees dans la creation de menus.
 * Par exemple la categorie Plat_chaud pourrait regrouper les types Pizza et Picard
 */
public class Categorie implements Serializable {

    String nom;

    ArrayList<Type> typeListe;

    public static ArrayList<Categorie> categorieListe = new ArrayList<>();

    /**
     * Cree une nouvelle categorie
     * @param pNom son nom
     */
    public Categorie(String pNom){
        nom = pNom;
        typeListe = new ArrayList<>();
    }

    public ArrayList<Type> getTypeListe(){
        return typeListe;
    }

    @Override
    public String toString() {
        return nom;
    }

}
