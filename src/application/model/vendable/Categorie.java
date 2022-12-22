package application.model.vendable;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;
import java.lang.reflect.Array;
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
    public Categorie(String pNom, ArrayList<Type> pTypeListe){
        id = UUID.randomUUID();
        nom = pNom;
        typeListe = new ArrayList<>(pTypeListe);
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

    /**
     * Retourne la liste des noms des categories existantes
     * @return la liste des noms
     */
    public static ArrayList<String> listeDesCategories(){
        ArrayList<String> listeNom = new ArrayList<>();
        for(Categorie c : categorieListe)
            listeNom.add(c.toString());
        return listeNom;
    }

    /**
     * Permet d'avoir la liste de tous les produits inclue dans cette categorie
     * Elle parcourt chaque type associee a cette categorie, et concatene les listes
     * de produits de chaque type
     * @return la liste de tous les produits
     */
    public ArrayList<Produit> listeTousLesProduits(){
        ArrayList<Produit> liste = new ArrayList<>();
        for(Type t : typeListe){
            liste.addAll(t.produitListe);
        }
        return liste;
    }

    public void ajouterType(Type pType){
        if(typeListe.contains(pType)==false)
            typeListe.add(pType);
    }


    public ArrayList<Type> getTypeListe(){
        return typeListe;
    }

    @Override
    public String toString() {
        return nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTypeListe(ArrayList<Type> pTypeListe) {
        typeListe.clear();
        typeListe.addAll(pTypeListe);
    }
}
