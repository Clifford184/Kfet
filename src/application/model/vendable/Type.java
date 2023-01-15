package application.model.vendable;

import application.outils.ImageManager;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Regroupe diffents produits qui ont un attribut commun
 * Par exemple le Type Pizza peut regrouper Pizza royale, Pizza 4 fromage, ...
 * Le Type Snack peut regrouper Snickers, Mars, Kinder Bueno, ...
 */
public class Type implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    UUID id;
    String nom;
    ArrayList<Produit> produitListe;

    String cheminImage;

    private static ArrayList<Type> typeListe = new ArrayList<>();

    /**
     * Cree un nouveau type
     * @param pNom son nom
     * @param pCheminImage le chemin de son image
     */
    public Type(String pNom, String pCheminImage) {
        id = UUID.randomUUID();
        nom = pNom;
        typeListe.add(this);
        produitListe = new ArrayList<>();

        cheminImage = ImageManager.genererNouvelleImage(pCheminImage, pNom);
    }

    /**
     * Appele avant la creation de l'objet lors de la deserialization
     * Verifie que l'objet n'a pas deja ete cree
     * @return le nouvel objet cree ou sa reference dans la liste statique
     */
    @Serial
    private Object readResolve() {

        for(Type p : typeListe){
            if(p.id.equals(this.id))
                return p;
        }
        typeListe.add(this);
        return this;
    }

    @Override
    public String toString() {
        return nom;
    }


    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String pChemin) {
        cheminImage = pChemin;
    }

    public void ajouterProduit(Produit pProduit){
        produitListe.add(pProduit);
    }

    public ArrayList<Produit> getProduitListe() {
        return produitListe;
    }

    public void setNom(String pNom){
        nom = pNom;
    }

    public String getNom() {
        return nom;
    }

    public static void deleteType(Type pType){
        typeListe.remove(pType);
    }

    public static ArrayList<Type> getTypeListe() {
        return typeListe;
    }

}
