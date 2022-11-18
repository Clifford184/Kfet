package application.model.vendable;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Decrit une categorie de type.
 * Une categorie permet de regrouper plusieurs types selon la volonte de l'utilisateur.
 * Un type peut appartenir a plusieurs categorie.
 * Les categories sont utilisees dans la creation de menus.
 * Par exemple la categorie Plat_chaud pourrait regrouper les types Pizza et Picard
 */
public class Categorie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    UUID id;
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
        categorieListe.add(this);
    }

    /**
     * Appele avant la creation de l'objet lors de la deserialization
     * Verifie que l'objet n'a pas deja ete cree
     * @return le nouvel objet cree ou sa reference dans la liste statique
     */
    @Serial
    private Object readResolve() {

        for(Categorie p : categorieListe){
            if(p.id.equals(this.id))
                return p;
        }
        categorieListe.add(this);
        return this;
    }

    public ArrayList<Type> getTypeListe(){
        return typeListe;
    }

    @Override
    public String toString() {
        return nom;
    }

}
