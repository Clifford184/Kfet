package application.Model.Soldable;

import java.awt.*;
import java.util.ArrayList;

/**
 * Decrit une categorie de type.
 * Une categorie permet de regrouper plusieurs types selon la volonte de l'utilisateur.
 * Un type peut appartenir a plusieurs categorie.
 * Les categories sont utilisees dans la creation de menus.
 * Par exemple la categorie Plat_chaud pourrait regrouper les types Pizza et Picard
 */
public class Categorie {

    String nom;
    Image image;

    ArrayList<Type> typeListe;

    public static ArrayList<Categorie> categorieListe = new ArrayList<>();

    /**
     * Cree une nouvelle categorie
     * @param pNom son nom
     * @param pTypeLieListe la liste de ses types
     */
    public Categorie(String pNom, ArrayList<Type> pTypeLieListe){
        nom = pNom;
        typeListe = pTypeLieListe;
    }

    @Override
    public String toString() {
        return nom;
    }
}
